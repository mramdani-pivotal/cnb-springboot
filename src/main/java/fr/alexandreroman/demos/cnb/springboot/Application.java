/*
 * Copyright (c) 2019 Pivotal Software, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fr.alexandreroman.demos.cnb.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@RestController
class GreetingsController {
    @GetMapping(value = "/greetings", produces = MediaType.TEXT_PLAIN_VALUE)
    String greetings() {
        return "Hello world!";
    }
}

@RestController
class InfoController {
    @GetMapping(value = "/info")
    Map<String, Object> info() {
        final Map<String, Object> info = new HashMap<>(3);
        info.put("java", "Java " + System.getProperty("java.version"));
        info.put("spring.boot", "Spring Boot " + SpringBootApplication.class.getPackage().getImplementationVersion());
        info.put("spring", "Spring " + ApplicationContext.class.getPackage().getImplementationVersion());
        return info;
    }
}
