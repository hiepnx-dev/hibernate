    -- Tạo bảng Bệnh nhân
    CREATE TABLE BenhNhan (
    MaBenhNhan INT PRIMARY KEY,
    TenBenhNhan NVARCHAR(100),
    Tuoi INT,
    GioiTinh NVARCHAR(10),
    -- Thêm các cột khác nếu cần
    );
    
    -- Tạo bảng Bác sĩ
    CREATE TABLE BacSi (
    MaBacSi INT PRIMARY KEY,
    TenBacSi NVARCHAR(100),
    ChuyenMon NVARCHAR(100),
    -- Thêm các cột khác nếu cần
    );
    
    -- Tạo bảng Lịch hẹn
    CREATE TABLE LichHen (
    MaLichHen INT PRIMARY KEY,
    MaBenhNhan INT FOREIGN KEY REFERENCES BenhNhan(MaBenhNhan),
    MaBacSi INT FOREIGN KEY REFERENCES BacSi(MaBacSi),
    NgayHen DATETIME,
    -- Thêm các cột khác nếu cần
    );
    
    -- Tạo bảng Đơn thuốc
    CREATE TABLE DonThuoc (
    MaDonThuoc INT PRIMARY KEY,
    MaBenhNhan INT FOREIGN KEY REFERENCES BenhNhan(MaBenhNhan),
    MaBacSi INT FOREIGN KEY REFERENCES BacSi(MaBacSi),
    NgayKeDon DATETIME,
    ChiTietThuoc NVARCHAR(MAX),
    -- Thêm các cột khác nếu cần
    );
    
    -- Tạo bảng Phòng khám
    CREATE TABLE PhongKham (
    MaPhongKham INT PRIMARY KEY,
    TenPhongKham NVARCHAR(100),
    -- Thêm các cột khác nếu cần
    );
    
    -- Tạo bảng Phân công bác sĩ vào phòng khám
    CREATE TABLE PhanCongBacSi (
    MaPhanCong INT PRIMARY KEY,
    MaBacSi INT FOREIGN KEY REFERENCES BacSi(MaBacSi),
    MaPhongKham INT FOREIGN KEY REFERENCES PhongKham(MaPhongKham),
    -- Thêm các cột khác nếu cần
    );
    
    -- Tạo bảng Chẩn đoán
    CREATE TABLE ChanDoan (
    MaChanDoan INT PRIMARY KEY,
    TenChanDoan NVARCHAR(100)
    -- Thêm các cột khác nếu cần
    );
    
    -- Tạo bảng Mối quan hệ nhiều-nhiều giữa Bệnh nhân và Chẩn đoán
    CREATE TABLE BenhNhan_ChanDoan (
    MaBenhNhan INT,
    MaChanDoan INT,
    PRIMARY KEY (MaBenhNhan, MaChanDoan),
    FOREIGN KEY (MaBenhNhan) REFERENCES BenhNhan(MaBenhNhan),
    FOREIGN KEY (MaChanDoan) REFERENCES ChanDoan(MaChanDoan)
    );
