package com.spring.data.jpa;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * A sample to show how Spring Data WebSupport enables url param to query the repository
 * {@link CustomerRepository} without any extra coding efforts. Its all handled by
 * Spring {@link org.springframework.data.repository.support.DomainClassConverter}
 * and {@link org.springframework.web.method.support.HandlerMethodArgumentResolver}
 *
 * Created by ninad on 2/26/2017.
 */
@Controller
@RequestMapping("/customers")
public class CustomerController {

    @RequestMapping("/{id}")
    public ResponseEntity<Customer> showCustomer(@PathVariable(value = "id") Customer customer, Model model){
        model.addAttribute(customer);
        return ResponseEntity.ok(customer);
    }
}
