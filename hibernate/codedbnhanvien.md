package com.example.demo.entity;

    import javax.persistence.*;
    import java.util.List;
    
    @Entity
    @Table(name = "phong_ban")
    public class PhongBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_phong_ban")
    private int maPhongBan;

    @Column(name = "ten_phong_ban")
    private String tenPhongBan;

    @OneToMany(mappedBy = "phongBan")
    private List<NhanVien> nhanViens;

    // Constructors, getters, and setters
    }
    
    @Entity
    @Table(name = "nhan_vien")
    public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_nhan_vien")
    private int maNhanVien;

    @Column(name = "ten_nhan_vien")
    private String tenNhanVien;

    @ManyToOne
    @JoinColumn(name = "ma_phong_ban")
    private PhongBan phongBan;

    @OneToOne(mappedBy = "nhanVien", cascade = CascadeType.ALL)
    private ChiTietNhanVien chiTietNhanVien;

    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL)
    private List<BaoCao> baoCaos;

    // Constructors, getters, and setters
    }

    @Entity
    @Table(name = "chi_tiet_nhan_vien")
    public class ChiTietNhanVien {
    @Id
    @Column(name = "ma_nhan_vien")
    private int maNhanVien;

    @Column(name = "dia_chi")
    private String diaChi;
    
    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @OneToOne
    @MapsId
    @JoinColumn(name = "ma_nhan_vien")
    private NhanVien nhanVien;

    // Constructors, getters, and setters
    }  

    @Entity
    @Table(name = "bao_cao")
    public class BaoCao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_bao_cao")
    private int maBaoCao;

    @Column(name = "mo_ta")
    private String moTa;

    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien")
    private NhanVien nhanVien;

    // Constructors, getters, and setters
    }