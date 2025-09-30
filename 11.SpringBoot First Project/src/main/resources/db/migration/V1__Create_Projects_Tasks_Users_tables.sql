-- Drop existing tables (for repeatable runs)
DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS projects;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS contacts;

-- Contacts
CREATE TABLE contacts (
  id            BIGINT AUTO_INCREMENT PRIMARY KEY,
  name     VARCHAR(255)      NOT NULL
);


-- USERS
CREATE TABLE users (
  id            BIGINT AUTO_INCREMENT PRIMARY KEY,
  last_name     VARCHAR(100)      NOT NULL,
  first_name    VARCHAR(100)      NOT NULL,
  email         VARCHAR(255)      NOT NULL UNIQUE,
  phone_number  VARCHAR(20)       NOT NULL,
  -- exactly 10 digits
  CONSTRAINT ck_users_phone_10_digits CHECK (REGEXP_LIKE(phone_number, '^[0-9]{10}$'))
);

-- PROJECTS
CREATE TABLE projects (
  id               BIGINT AUTO_INCREMENT PRIMARY KEY,
  title            VARCHAR(20)      NOT NULL,
  description      VARCHAR(255),               -- may be NULL
  operation_mode   VARCHAR(20)      NOT NULL,  -- 'AGILE' (time & materials) or 'FIXED_PRICE'
  manager_id       BIGINT           NOT NULL,  -- FK to users.id
  budget_eur       INT              NOT NULL,  -- initial budget, no decimals
  start_date       DATE             NOT NULL,
  estimated_days   INT              NOT NULL,  -- number of allocated days, no decimals

  CONSTRAINT ck_projects_mode CHECK (operation_mode IN ('AGILE','FIXED_PRICE')),
  CONSTRAINT ck_projects_budget_nonneg CHECK (budget_eur >= 0),
  CONSTRAINT ck_projects_estimated_days_nonneg CHECK (estimated_days >= 0),

  CONSTRAINT fk_projects_manager
    FOREIGN KEY (manager_id) REFERENCES users(id)
);

CREATE INDEX idx_projects_manager ON projects(manager_id);

-- TASKS
CREATE TABLE tasks (
  id               BIGINT AUTO_INCREMENT PRIMARY KEY,
  tracking_number  VARCHAR(30)      NOT NULL,  -- e.g. "TASK-2025-0001"
  hourly_rate_eur  INT              NOT NULL,  -- e.g. 35 €/h, no decimals
  duration_hours   INT              NOT NULL,  -- e.g. 7 h, no decimals
  project_id       BIGINT           NOT NULL,  -- FK to projects.id

  CONSTRAINT ck_tasks_hourly_rate_nonneg CHECK (hourly_rate_eur >= 0),
  CONSTRAINT ck_tasks_duration_nonneg CHECK (duration_hours >= 0),

  CONSTRAINT fk_tasks_project
    FOREIGN KEY (project_id) REFERENCES projects(id)
);

-- Optional: avoid duplicate tracking numbers within the same project
CREATE UNIQUE INDEX uq_tasks_project_tracking
  ON tasks(project_id, tracking_number);
