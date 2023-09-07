package mml.wallet.domain.services;

import mml.wallet.domain.entities.Transfer;
import mml.wallet.domain.entities.User;
import mml.wallet.domain.erros.InsuficientBalanceError;
import mml.wallet.domain.erros.TransferRejectedError;
import mml.wallet.domain.repositories.UserRepository;
import mml.wallet.domain.useCases.NotifyUser;
import mml.wallet.domain.useCases.TransferMoney;
import mml.wallet.domain.useCases.VerifyTransfer;

import java.util.Date;

public class TransferService {

    private NotifyUser notifyUser;
    private TransferMoney transferMoney;
    private VerifyTransfer verifyTransfer;
    private UserRepository userRepository;


    public Transfer transfer(String senderUserDocumentNumber, String receiverUserDocumentNumber, Double value){

        User sender = this.userRepository.findByDocumentNumber(senderUserDocumentNumber);
        User receiver = this.userRepository.findByDocumentNumber(receiverUserDocumentNumber);

        if(sender.getBalance() > value){
            throw new InsuficientBalanceError();
        }

        Transfer newTransfer = new Transfer(sender,receiver,new Date(),value);

        Boolean isTransferValid = this.verifyTransfer.exec(newTransfer);

        if(!isTransferValid){
            throw new TransferRejectedError();
        }

        Transfer executedTransfer = this.transferMoney.exec(newTransfer);

        try {
            this.notifyUser.exec(receiver, executedTransfer);
        }catch (Error ignored){}


        return executedTransfer;
    }
}
