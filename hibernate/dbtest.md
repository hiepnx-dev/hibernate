    -- Tạo bảng PhongBan
    CREATE TABLE PhongBan (
    MaPhongBan INT PRIMARY KEY,
    TenPhongBan NVARCHAR(100)
    );
    
    -- Tạo bảng NhanVien
    CREATE TABLE NhanVien (
    MaNhanVien INT PRIMARY KEY,
    TenNhanVien NVARCHAR(100),
    MaPhongBan INT,
    FOREIGN KEY (MaPhongBan) REFERENCES PhongBan(MaPhongBan)
    );
    
    -- Tạo bảng ChiTietNhanVien (Mối quan hệ một-một)
    CREATE TABLE ChiTietNhanVien (
    MaNhanVien INT PRIMARY KEY,
    DiaChi NVARCHAR(255),
    SoDienThoai NVARCHAR(20),
    FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien)
    );
    
    
    -- Tạo bảng BaoCao (Mối quan hệ nhiều-một)
    CREATE TABLE BaoCao (
    MaBaoCao INT PRIMARY KEY,
    MoTa NVARCHAR(255),
    MaNhanVien INT,
    FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien)
    );
    
    -- Tạo bảng MonHoc
    CREATE TABLE MonHoc (
    MaMonHoc INT PRIMARY KEY,
    TenMonHoc NVARCHAR(100)
    );
    
    -- Tạo bảng SinhVien
    CREATE TABLE SinhVien (
    MaSinhVien INT PRIMARY KEY,
    TenSinhVien NVARCHAR(100)
    );
    
    -- Tạo bảng BaiGiang (Mối quan hệ một-nhiều)
    CREATE TABLE BaiGiang (
    MaBaiGiang INT PRIMARY KEY,
    NoiDung NVARCHAR(255),
    MaMonHoc INT,
    FOREIGN KEY (MaMonHoc) REFERENCES MonHoc(MaMonHoc)
    );
    -----------------------------------------------------------------------
    
    -- Tạo bảng Phòng ban
    CREATE TABLE PhongBan (
    MaPhongBan INT PRIMARY KEY,
    TenPhongBan NVARCHAR(100)
    );
    
    -- Tạo bảng Nhân viên
    CREATE TABLE NhanVien (
    MaNhanVien INT PRIMARY KEY,
    TenNhanVien NVARCHAR(100),
    MaPhongBan INT FOREIGN KEY REFERENCES PhongBan(MaPhongBan)
    );
    
    -- Tạo bảng Chi tiết nhân viên (Mối quan hệ một-một)
    CREATE TABLE ChiTietNhanVien (
    MaNhanVien INT PRIMARY KEY,
    DiaChi NVARCHAR(255),
    SoDienThoai NVARCHAR(20),
    FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien)
    );
    
    -- Tạo bảng Môn học
    CREATE TABLE MonHoc (
    MaMonHoc INT PRIMARY KEY,
    TenMonHoc NVARCHAR(100)
    );
    
    -- Tạo bảng Sinh viên
    CREATE TABLE SinhVien (
    MaSinhVien INT PRIMARY KEY,
    TenSinhVien NVARCHAR(100)
    );
    
    -- Tạo bảng liên kết SinhVien_MonHoc (Mối quan hệ nhiều-nhiều)
    CREATE TABLE SinhVien_MonHoc (
    MaSinhVien INT,
    MaMonHoc INT,
    PRIMARY KEY (MaSinhVien, MaMonHoc),
    FOREIGN KEY (MaSinhVien) REFERENCES SinhVien(MaSinhVien),
    FOREIGN KEY (MaMonHoc) REFERENCES MonHoc(MaMonHoc)
    );

------------------------------------------------------------------------------------
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