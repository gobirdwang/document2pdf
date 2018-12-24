package com.th.documentconversion;

import com.th.documentconversion.openoffice.OfficeToPdfWithOpenOffice;

public class main {
    public static void main(String[] args){
        OfficeToPdfWithOpenOffice.office2Pdf(Params.oriPath+Params.oriName,Params.targetPath+Params.targetName);
    }
}
