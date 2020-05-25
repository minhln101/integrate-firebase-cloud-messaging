package vn.nerdcode.notification_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Minh Lee on 22/05/2020.
 */
@RestController
@RequestMapping("api/v1/dummy-controller")
public class DummyController {

  @GetMapping
  public void getMe() {
  }
}
