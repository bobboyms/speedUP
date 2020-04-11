package br.com.speedup.controller;

import br.com.speedup.dbengine.dbconnection.Connection;
import br.com.speedup.dbengine.dbconnection.ConnectionDB;
import br.com.speedup.modeldto.CommandDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/command")
public class MainController {

    private static Connection connection = ConnectionDB.getInstance();

    @GetMapping(path = "/get/{key}")
    public CommandDTO getDocument(@PathVariable("key") String key) {

        String value = connection.createCommand("get " + key).getDocument();

        CommandDTO commandDTO = new CommandDTO();
        commandDTO.setKey(key);
        commandDTO.setValue(value);

        return commandDTO;
    }

    @DeleteMapping(path = "/delete/{key}")
    public CommandDTO deleteDocument(@PathVariable("key") String key) {

        connection.createCommand("get " + key).deleteDocument();

        CommandDTO commandDTO = new CommandDTO();
        commandDTO.setKey(key);
        commandDTO.setValue("OK");

        return commandDTO;
    }

    @PostMapping(path = "/set")
    public CommandDTO setDocument(@RequestBody CommandDTO commandDTO) {

        connection.createCommand("set " + commandDTO.getKey() + " " + commandDTO.getValue()).setDocument();
        commandDTO.setValue("OK");

        return commandDTO;

    }

}
