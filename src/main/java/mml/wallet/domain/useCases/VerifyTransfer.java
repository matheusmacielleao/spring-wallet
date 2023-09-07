package mml.wallet.domain.useCases;

import mml.wallet.domain.entities.Transfer;

public interface VerifyTransfer {

     Boolean exec(Transfer transfer);
}
