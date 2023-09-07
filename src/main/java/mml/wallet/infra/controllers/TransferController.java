package mml.wallet.infra.controllers;

import jakarta.websocket.server.PathParam;
import mml.wallet.domain.entities.Transfer;
import mml.wallet.domain.services.TransferService;
import mml.wallet.infra.controllers.dtos.ExecuteTransferDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {
    private TransferService transferService;

    @PostMapping("users/{documentNumber}/transfer")
    public Transfer executeTranfer(@RequestBody ExecuteTransferDto executeTransferDto, @PathVariable String documentNumber){

            return this.transferService.transfer(documentNumber,executeTransferDto.receiverId,executeTransferDto.value);


    }
}
