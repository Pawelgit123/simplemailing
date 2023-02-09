package com.exercise.simplemailing.userWithMail;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mail")
public class UserWithMailController {

    private final UserWithMailServiceCreate userWithMailServiceCreate;
    private final UserWithMailServiceSearch userWithMailServiceSearch;
    private final UserWithMailServiceRemove userWithMailServiceRemove;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserWithMailDTO createNewUserWithMail(@RequestBody UserWithMailDTO userWithMailDTO)  {

        return userWithMailServiceCreate.createNewUserWithMail(userWithMailDTO);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public UserWithMailDTOListed getAllUserWithMail() {

        return userWithMailServiceSearch.getAllUserWithMail();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserWithMailDTO getUserWithMailById(@PathVariable Long id) {

        return userWithMailServiceSearch.getUserWithMailById(id);
    }

    @GetMapping("/address/{address}")
    @ResponseStatus(HttpStatus.OK)
    public UserWithMailDTO getUserWithMailByAddress(@PathVariable String address) {

        return userWithMailServiceSearch.getUserWithMailByAddress(address);
    }

    @DeleteMapping("/address/{address}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserWithMailByAddress(@PathVariable String address) {

        userWithMailServiceRemove.removeUserWithMailByAddress(address);
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserWithMailById(@PathVariable Long id) {

        userWithMailServiceRemove.removeUserWithMailById(id);
    }


}
