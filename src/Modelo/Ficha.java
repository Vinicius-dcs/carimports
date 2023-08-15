/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author vinic
 */
public class Ficha {
    
    private String nomeColchao;
    private String codigo;
    private String suportePeso;
    private String pillowEuro;
    private String revestSuperior;
    private String revestLateral;
    private String revestInferior;
    private String molejo;
    private String nivelConforto;
    private String garantiaColchao;
    private String garantiaBase;
    private String estruturaBase;
    private String revestSupBase;
    private String revestLatBase;
    private String pes;
    private String altColchao;
    private String altBase;
    private String altPes;
    private String altTotalConjunto;
    private String comp1;
    private String comp2;
    private String comp3;
    private String comp4;
    private String comp5;
    private String comp6;
    private String comp7;
    private String comp8;
    private String comp9;
    private String comp10;
    private String comp11;
    private String comp12;
    private String comp13;
    private String comp14;
    private String diferencial1;
    private String diferencial2;
    private String diferencial3;
    private String diferencial4;
    private String diferencial5;
    private byte[] imagem;
    private String nomeElaborador;

    public Ficha(String nomeColchao, String codigo, String suportePeso, String pillowEuro, String revestSuperior, String revestLateral, String revestInferior, String molejo, String nivelConforto, String garantiaColchao, String garantiaBase, String estruturaBase, String revestSupBase, String revestLatBase, String pes, String altColchao, String altBase, String altPes, String altTotalConjunto, String comp1, String comp2, String comp3, String comp4, String comp5, String comp6, String comp7, String comp8, String comp9, String comp10, String comp11, String comp12, String comp13, String comp14, String diferencial1, String diferencial2, String diferencial3, String diferencial4, String diferencial5, byte[] imagem) {
        this.nomeColchao = nomeColchao;
        this.codigo = codigo;
        this.suportePeso = suportePeso;
        this.pillowEuro = pillowEuro;
        this.revestSuperior = revestSuperior;
        this.revestLateral = revestLateral;
        this.revestInferior = revestInferior;
        this.molejo = molejo;
        this.nivelConforto = nivelConforto;
        this.garantiaColchao = garantiaColchao;
        this.garantiaBase = garantiaBase;
        this.estruturaBase = estruturaBase;
        this.revestSupBase = revestSupBase;
        this.revestLatBase = revestLatBase;
        this.pes = pes;
        this.altColchao = altColchao;
        this.altBase = altBase;
        this.altPes = altPes;
        this.altTotalConjunto = altTotalConjunto;
        this.comp1 = comp1;
        this.comp2 = comp2;
        this.comp3 = comp3;
        this.comp4 = comp4;
        this.comp5 = comp5;
        this.comp6 = comp6;
        this.comp7 = comp7;
        this.comp8 = comp8;
        this.comp9 = comp9;
        this.comp10 = comp10;
        this.comp11 = comp11;
        this.comp12 = comp12;
        this.comp13 = comp13;
        this.comp14 = comp14;
        this.diferencial1 = diferencial1;
        this.diferencial2 = diferencial2;
        this.diferencial3 = diferencial3;
        this.diferencial4 = diferencial4;
        this.diferencial5 = diferencial5;
        this.imagem = imagem;
    }

    public Ficha(String codigo) {
        this.codigo = codigo;
    }
    
    public String getNomeColchao() {
        return nomeColchao;
    }

    public void setNomeColchao(String nomeColchao) {
        this.nomeColchao = nomeColchao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSuportePeso() {
        return suportePeso;
    }

    public void setSuportePeso(String suportePeso) {
        this.suportePeso = suportePeso;
    }

    public String getPillowEuro() {
        return pillowEuro;
    }

    public void setPillowEuro(String pillowEuro) {
        this.pillowEuro = pillowEuro;
    }

    public String getRevestSuperior() {
        return revestSuperior;
    }

    public void setRevestSuperior(String revestSuperior) {
        this.revestSuperior = revestSuperior;
    }

    public String getRevestLateral() {
        return revestLateral;
    }

    public void setRevestLateral(String revestLateral) {
        this.revestLateral = revestLateral;
    }

    public String getRevestInferior() {
        return revestInferior;
    }

    public void setRevestInferior(String revestInferior) {
        this.revestInferior = revestInferior;
    }

    public String getMolejo() {
        return molejo;
    }

    public void setMolejo(String molejo) {
        this.molejo = molejo;
    }

    public String getNivelConforto() {
        return nivelConforto;
    }

    public void setNivelConforto(String nivelConforto) {
        this.nivelConforto = nivelConforto;
    }

    public String getGarantiaColchao() {
        return garantiaColchao;
    }

    public void setGarantiaColchao(String garantiaColchao) {
        this.garantiaColchao = garantiaColchao;
    }

    public String getGarantiaBase() {
        return garantiaBase;
    }

    public void setGarantiaBase(String garantiaBase) {
        this.garantiaBase = garantiaBase;
    }

    public String getEstruturaBase() {
        return estruturaBase;
    }

    public void setEstruturaBase(String estruturaBase) {
        this.estruturaBase = estruturaBase;
    }

    public String getRevestSupBase() {
        return revestSupBase;
    }

    public void setRevestSupBase(String revestSupBase) {
        this.revestSupBase = revestSupBase;
    }

    public String getRevestLatBase() {
        return revestLatBase;
    }

    public void setRevestLatBase(String revestLatBase) {
        this.revestLatBase = revestLatBase;
    }

    public String getPes() {
        return pes;
    }

    public void setPes(String pes) {
        this.pes = pes;
    }

    public String getAltColchao() {
        return altColchao;
    }

    public void setAltColchao(String altColchao) {
        this.altColchao = altColchao;
    }

    public String getAltBase() {
        return altBase;
    }

    public void setAltBase(String altBase) {
        this.altBase = altBase;
    }

    public String getAltPes() {
        return altPes;
    }

    public void setAltPes(String altPes) {
        this.altPes = altPes;
    }

    public String getAltTotalConjunto() {
        return altTotalConjunto;
    }

    public void setAltTotalConjunto(String altTotalConjunto) {
        this.altTotalConjunto = altTotalConjunto;
    }

    public String getComp1() {
        return comp1;
    }

    public void setComp1(String comp1) {
        this.comp1 = comp1;
    }

    public String getComp2() {
        return comp2;
    }

    public void setComp2(String comp2) {
        this.comp2 = comp2;
    }

    public String getComp3() {
        return comp3;
    }

    public void setComp3(String comp3) {
        this.comp3 = comp3;
    }

    public String getComp4() {
        return comp4;
    }

    public void setComp4(String comp4) {
        this.comp4 = comp4;
    }

    public String getComp5() {
        return comp5;
    }

    public void setComp5(String comp5) {
        this.comp5 = comp5;
    }

    public String getComp6() {
        return comp6;
    }

    public void setComp6(String comp6) {
        this.comp6 = comp6;
    }

    public String getComp7() {
        return comp7;
    }

    public void setComp7(String comp7) {
        this.comp7 = comp7;
    }

    public String getComp8() {
        return comp8;
    }

    public void setComp8(String comp8) {
        this.comp8 = comp8;
    }

    public String getComp9() {
        return comp9;
    }

    public void setComp9(String comp9) {
        this.comp9 = comp9;
    }

    public String getComp10() {
        return comp10;
    }

    public void setComp10(String comp10) {
        this.comp10 = comp10;
    }

    public String getComp11() {
        return comp11;
    }

    public void setComp11(String comp11) {
        this.comp11 = comp11;
    }

    public String getComp12() {
        return comp12;
    }

    public void setComp12(String comp12) {
        this.comp12 = comp12;
    }

    public String getComp13() {
        return comp13;
    }

    public void setComp13(String comp13) {
        this.comp13 = comp13;
    }

    public String getComp14() {
        return comp14;
    }

    public void setComp14(String comp14) {
        this.comp14 = comp14;
    }

    public String getDiferencial1() {
        return diferencial1;
    }

    public void setDiferencial1(String diferencial1) {
        this.diferencial1 = diferencial1;
    }

    public String getDiferencial2() {
        return diferencial2;
    }

    public void setDiferencial2(String diferencial2) {
        this.diferencial2 = diferencial2;
    }

    public String getDiferencial3() {
        return diferencial3;
    }

    public void setDiferencial3(String diferencial3) {
        this.diferencial3 = diferencial3;
    }

    public String getDiferencial4() {
        return diferencial4;
    }

    public void setDiferencial4(String diferencial4) {
        this.diferencial4 = diferencial4;
    }

    public String getDiferencial5() {
        return diferencial5;
    }

    public void setDiferencial5(String diferencial5) {
        this.diferencial5 = diferencial5;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }  

    public String getNomeElaborador() {
        return nomeElaborador;
    }

    public void setNomeElaborador(String nomeElaborador) {
        this.nomeElaborador = nomeElaborador;
    }

}
