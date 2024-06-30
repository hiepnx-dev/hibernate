    package com.example.demo.entity.sinhvien;
    
    import jakarta.persistence.*;
    import lombok.Data;
    
    @Entity
    @Data
    @Table(name = "bai_giang")
    public class BaiGiang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_bai_giang")
    private int maBaiGiang;
    @Column(name = "noi_dung")
    private String noiDung;
    
        @ManyToOne
        @JoinColumn(name = "maMonHoc")
        private MonHoc monHoc;
    }
    ///
    package com.example.demo.entity.sinhvien;
    
    import jakarta.persistence.*;
    
    import java.util.List;
    
    @Entity
    @Table(name = "MonHoc")
    public class MonHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaMonHoc")
    private int maMonHoc;
    
        @Column(name = "TenMonHoc")
        private String tenMonHoc;
    
    //    @ManyToMany(mappedBy = "monHocs")
    //    private List<SinhVien> sinhViens;
    
        @ManyToMany(mappedBy = "monHocs")
        private List<SinhVien> sinhViens;
    }
    ///
    package com.example.demo.entity.sinhvien;
    
    import jakarta.persistence.*;
    
    import java.util.List;
    
    @Entity
    @Table(name = "SinhVien")
    public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaSinhVien")
    private int maSinhVien;
    
        @Column(name = "TenSinhVien")
        private String tenSinhVien;
    
    //    @ManyToMany
    //    @JoinTable(
    //            name = "SinhVien_MonHoc",
    //            joinColumns = @JoinColumn(name = "MaSinhVien"),
    //            inverseJoinColumns = @JoinColumn(name = "MaMonHoc")
    //    )
    //    private List<MonHoc> monHocs;
    
        @ManyToMany
        @JoinTable(
                name = "sinh_vien_mon_hoc",
                joinColumns = @JoinColumn(name = "MaSinhVien"),
                inverseJoinColumns = @JoinColumn(name = "MaMonHoc")
        )
        private List<MonHoc>  monHocs;
    
        // Constructors, getters, and setters
    }
