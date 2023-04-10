package com.mservice.shared.sharedmodels;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mservice.allinone.models.PayGateResponse;
import com.mservice.shared.exception.MoMoException;
import com.mservice.shared.utils.Execute;

/**
 * @author hainguyen
 * Documention: https://developers.momo.vn
 */

public abstract class AbstractProcess<T, V> {

    protected PartnerInfo partnerInfo;
    protected Environment environment;
    protected Execute execute = new Execute();

    public AbstractProcess(Environment environment) {
        this.environment = environment;
        this.partnerInfo = environment.getPartnerInfo();
    }

    public static Gson getGson() {
        return new GsonBuilder()
                .disableHtmlEscaping()
                .create();
    }

    /**
     * Some errors will be showed in process
     * Read detail error in documents
     * [Find out] (https:/developers.momo.vn) - Section 7
     *
     * @param errorCode
     * @throws Exception
     */
    public static void errorMoMoProcess(int errorCode) throws MoMoException {

        switch (errorCode) {
            case 0:
                // O is meaning success
                break;
            case 1:
                throw new MoMoException("Empty access key or partner code");
        }
    }

    public abstract V execute(T request) throws MoMoException;
}
