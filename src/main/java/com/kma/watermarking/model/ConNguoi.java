package com.kma.watermarking.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "con_nguoi")
@Builder
@Getter
public class ConNguoi {
    @Column(name = "ten")
    private String ten;
    @Column(name = "tuoi")
    private int tuoi;
    @Column(name = "dia_chi")
    private String dia_chi;
    @Id
    @Column(name = "so_chung_minh")
    private String so_chung_minh;
    public String getTen(){
        return this.ten;
    }
    public int getTuoi(){
        return this.tuoi;
    }
    public String getDiaChi(){
        return this.dia_chi;
    }
    public String getSo_chung_minh(){
        return this.so_chung_minh;
    }
}
