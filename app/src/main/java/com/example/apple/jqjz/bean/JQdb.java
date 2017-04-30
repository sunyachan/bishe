package com.example.apple.jqjz.bean;

/**
 * Created by apple on 17/4/30.
 */

public class JQdb {
    public String PI201;
    public String TI201;
    public String TIC202;
    public String PI211;
    public String TI208;
    public String PI207;
    public String PI208;
    public String TIC203;
    public String PI202;
    public String LIC202;
    public String PI206;
    public String TIC201;
    public String PI212;
    public String PIC101;
    public String PI106;

    public JQdb() {
    }

    public JQdb(String LIC202, String PI106, String PI201, String PI202, String PI206,
                String PI207, String PI208, String PI211, String PI212, String PIC101,
                String TI201, String TI208, String TIC201, String TIC202, String TIC203) {
        this.LIC202 = LIC202;
        this.PI106 = PI106;
        this.PI201 = PI201;
        this.PI202 = PI202;
        this.PI206 = PI206;
        this.PI207 = PI207;
        this.PI208 = PI208;
        this.PI211 = PI211;
        this.PI212 = PI212;
        this.PIC101 = PIC101;
        this.TI201 = TI201;
        this.TI208 = TI208;
        this.TIC201 = TIC201;
        this.TIC202 = TIC202;
        this.TIC203 = TIC203;
    }

    public String getLIC202() {
        return LIC202;
    }

    public void setLIC202(String LIC202) {
        this.LIC202 = LIC202;
    }

    public String getPI106() {
        return PI106;
    }

    public void setPI106(String PI106) {
        this.PI106 = PI106;
    }

    public String getPI201() {
        return PI201;
    }

    public void setPI201(String PI201) {
        this.PI201 = PI201;
    }

    public String getPI202() {
        return PI202;
    }

    public void setPI202(String PI202) {
        this.PI202 = PI202;
    }

    public String getPI206() {
        return PI206;
    }

    public void setPI206(String PI206) {
        this.PI206 = PI206;
    }

    public String getPI207() {
        return PI207;
    }

    public void setPI207(String PI207) {
        this.PI207 = PI207;
    }

    public String getPI208() {
        return PI208;
    }

    public void setPI208(String PI208) {
        this.PI208 = PI208;
    }

    public String getPI211() {
        return PI211;
    }

    public void setPI211(String PI211) {
        this.PI211 = PI211;
    }

    public String getPI212() {
        return PI212;
    }

    public void setPI212(String PI212) {
        this.PI212 = PI212;
    }

    public String getPIC101() {
        return PIC101;
    }

    public void setPIC101(String PIC101) {
        this.PIC101 = PIC101;
    }

    public String getTI201() {
        return TI201;
    }

    public void setTI201(String TI201) {
        this.TI201 = TI201;
    }

    public String getTI208() {
        return TI208;
    }

    public void setTI208(String TI208) {
        this.TI208 = TI208;
    }

    public String getTIC201() {
        return TIC201;
    }

    public void setTIC201(String TIC201) {
        this.TIC201 = TIC201;
    }

    public String getTIC202() {
        return TIC202;
    }

    public void setTIC202(String TIC202) {
        this.TIC202 = TIC202;
    }

    public String getTIC203() {
        return TIC203;
    }

    public void setTIC203(String TIC203) {
        this.TIC203 = TIC203;
    }
    public String get(int i){
        if(i==0){
            return getPI201();
        }else if (i==1){
            return getTI201();
        }else if (i==2){
            return getTIC202();
        }else if (i==3){
            return getPI211();
        }else if (i==4){
            return getTI208();
        }else if (i==5){
            return getPI207();
        }else if (i==6){
            return getPI208();
        }else if (i==7){
            return getTIC203();
        }else if (i==8){
            return getPI202();
        }else if (i==9){
            return getLIC202();
        }else if (i==10){
            return getPI206();
        }else if (i==11){
            return getTIC201();
        }else if (i==12){
            return getPI212();
        }else if (i==13){
            return getPIC101();
        }else if (i==14){
            return getPI106();
        }else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "JQdb{" +
                "LIC202='" + LIC202 + '\'' +
                ", PI201='" + PI201 + '\'' +
                ", TI201='" + TI201 + '\'' +
                ", TIC202='" + TIC202 + '\'' +
                ", PI211='" + PI211 + '\'' +
                ", TI208='" + TI208 + '\'' +
                ", PI207='" + PI207 + '\'' +
                ", PI208='" + PI208 + '\'' +
                ", TIC203='" + TIC203 + '\'' +
                ", PI202='" + PI202 + '\'' +
                ", PI206='" + PI206 + '\'' +
                ", TIC201='" + TIC201 + '\'' +
                ", PI212='" + PI212 + '\'' +
                ", PIC101='" + PIC101 + '\'' +
                ", PI106='" + PI106 + '\'' +
                '}';
    }
}
