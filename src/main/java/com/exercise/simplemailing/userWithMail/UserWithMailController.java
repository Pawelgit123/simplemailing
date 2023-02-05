package com.exercise.simplemailing.userWithMail;

import com.exercise.simplemailing.logs.RequestLog;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mail")
public class UserWithMailController {

    private final UserWithMailServiceCreate userWithMailServiceCreate;
    private final UserWithMailServiceSearch userWithMailServiceSearch;
    private final UserWithMailServiceRemove userWithMailServiceRemove;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserWithMailDTO createNewUserWithMail(@RequestBody UserWithMailDTO userWithMailDTO) throws IOException {

        //TODO check this
        RequestLog.createNewLog(RequestLog.createRequestFileWriter(),"new UserWithMail created, email address: " + userWithMailDTO.getEmail());

        return userWithMailServiceCreate.createNewUserWithMail(userWithMailDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public UserWithMailDTOListed getAllUserWithMail() {

        return userWithMailServiceSearch.getAllUserWithMail();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserWithMailDTO getUserWithMailById(@PathVariable Long id) {

        return userWithMailServiceSearch.getUserWithMailById(id);
    }

    @GetMapping("/{address}")
    @ResponseStatus(HttpStatus.OK)
    public UserWithMailDTO getUserWithMailByAddress(@PathVariable String address) {

        return userWithMailServiceSearch.getUserWithMailByAddress(address);
    }

    @DeleteMapping("/{address}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserWithMailByAddress(@PathVariable String address) {

        userWithMailServiceRemove.removeUserWithMailByAddress(address);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserWithMailById(@PathVariable Long id) {

        userWithMailServiceRemove.removeUserWithMailById(id);
    }


}
