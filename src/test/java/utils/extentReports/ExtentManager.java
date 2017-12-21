package utils.extentReports;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports();
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("src/test/java/utils/extentReports/Report.html");
            htmlReporter.loadConfig("extent-config.xml");
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }
}
