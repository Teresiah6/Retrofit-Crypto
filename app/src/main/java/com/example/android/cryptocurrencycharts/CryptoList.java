package com.example.android.cryptocurrencycharts;

public class CryptoList {

    public String fsym;
    public String tysms;
    public boolean tryconversion;
    public boolean extraparams;

    public CryptoList(){

    }

    public CryptoList(String fsym, String tysms, boolean tryconversion, boolean extraparams) {
        this.fsym = fsym;
        this.tysms = tysms;
        this.tryconversion = tryconversion;
        this.extraparams = extraparams;
    }

    public String getFsym() {
        return fsym;
    }

    public void setFsym(String fsym) {
        this.fsym = fsym;
    }

    public String getTysms() {
        return tysms;
    }

    public void setTysms(String tysms) {
        this.tysms = tysms;
    }

    public boolean isTryconversion() {
        return tryconversion;
    }

    public void setTryconversion(boolean tryconversion) {
        this.tryconversion = tryconversion;
    }

    public boolean isExtraparams() {
        return extraparams;
    }

    public void setExtraparams(boolean extraparams) {
        this.extraparams = extraparams;
    }
}
