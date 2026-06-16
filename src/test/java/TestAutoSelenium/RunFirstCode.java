package TestAutoSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RunFirstCode {
    public static void main(String[] args) throws InterruptedException {
        // Khởi tạo đối tượng WebDriver với trình duyệt Chrome
        WebDriver driver = new ChromeDriver();

        // Phóng to cửa sổ trình duyệt
        driver.manage().window().maximize();

        // Chuyển trình duyệt sang chế độ toàn màn hình
        driver.manage().window().fullscreen();

        // Mở website bằng phương thức get()
//        driver.get("https://demoqa.com/");

        // Mở website bằng phương thức navigate().to()
        // Tương tự get(), nhưng navigate còn hỗ trợ back(), forward(), refresh()
        driver.navigate().to("https://demoqa.com/");

        // Lấy tiêu đề (title) của trang web hiện tại và ỉn ra màn console
        System.out.println(driver.getTitle());

        // Dừng chương trình 3 giây để quan sát trình duyệt
        Thread.sleep(3000);

        // Đóng toàn bộ cửa sổ trình duyệt và kết thúc phiên làm việc
        driver.quit();
    }
}
