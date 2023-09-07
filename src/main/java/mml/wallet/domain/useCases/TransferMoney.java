package mml.wallet.domain.useCases;

import mml.wallet.domain.entities.Transfer;
import mml.wallet.domain.entities.User;

public interface TransferMoney{

     Transfer exec(Transfer t);

}
