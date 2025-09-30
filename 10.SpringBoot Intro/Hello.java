@Controller
public class Hello {
 
  @GetMapping("/")
  public String index() {
    return "Hello !!!"
  }
}
