package com.university.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.WebApplicationType;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class UniversityWebApplication {

    public static void main(String[] args) {
        // Load .env variables into System properties for Spring Boot
        try {
            Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
            if (dotenv.get("DB_URL") != null) System.setProperty("DB_URL", dotenv.get("DB_URL"));
            if (dotenv.get("DB_USERNAME") != null) System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
            if (dotenv.get("DB_PASSWORD") != null) System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
            if (dotenv.get("PORT") != null) System.setProperty("PORT", dotenv.get("PORT"));
        } catch (Exception e) {
            // Ignore missing .env in production
        }

        SpringApplication app = new SpringApplication(UniversityWebApplication.class);
        
        // Check if --cli flag is passed
        boolean isCliMode = false;
        for (String arg : args) {
            if (arg.equals("--cli")) {
                isCliMode = true;
                break;
            }
        }
        
        if (isCliMode) {
            app.setWebApplicationType(WebApplicationType.NONE);
            app.run(args);
            // After Spring context loads, run the CLI
            MainManager.main(new String[]{});
        } else {
            app.run(args);
        }
    }
}
