USE [learn_hibernate]
GO
/****** Object:  Table [dbo].[bai_giang]    Script Date: 3/24/2024 1:30:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[bai_giang](
	[ma_bai_giang] [int] IDENTITY(1,1) NOT NULL,
	[ma_mon_hoc] [int] NULL,
	[noi_dung] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ma_bai_giang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[bao_cao]    Script Date: 3/24/2024 1:30:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[bao_cao](
	[ma_bao_cao] [int] IDENTITY(1,1) NOT NULL,
	[ma_nhan_vien] [int] NULL,
	[mo_ta] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ma_bao_cao] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[chi_tiet_nhan_vien]    Script Date: 3/24/2024 1:30:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chi_tiet_nhan_vien](
	[ma_nhan_vien] [int] NOT NULL,
	[so_dien_thoai] [int] NULL,
	[dia_chi] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ma_nhan_vien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[mon_hoc]    Script Date: 3/24/2024 1:30:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[mon_hoc](
	[ma_mon_hoc] [int] IDENTITY(1,1) NOT NULL,
	[ten_mon_hoc] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ma_mon_hoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[nhan_vien]    Script Date: 3/24/2024 1:30:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[nhan_vien](
	[ma_nhan_vien] [int] IDENTITY(1,1) NOT NULL,
	[ma_phong_ban] [int] NULL,
	[ten_nhan_vien] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ma_nhan_vien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[phong_ban]    Script Date: 3/24/2024 1:30:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[phong_ban](
	[ma_phong_ban] [int] IDENTITY(1,1) NOT NULL,
	[ten_phong_ban] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ma_phong_ban] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sinh_vien]    Script Date: 3/24/2024 1:30:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sinh_vien](
	[ma_sinh_vien] [int] IDENTITY(1,1) NOT NULL,
	[ten_sinh_vien] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ma_sinh_vien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sinh_vien_mon_hoc]    Script Date: 3/24/2024 1:30:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sinh_vien_mon_hoc](
	[ma_mon_hoc] [int] NOT NULL,
	[ma_sinh_vien] [int] NOT NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[bai_giang]  WITH CHECK ADD  CONSTRAINT [FKmadbdlsb30kgmig4g4fo07yjw] FOREIGN KEY([ma_mon_hoc])
REFERENCES [dbo].[mon_hoc] ([ma_mon_hoc])
GO
ALTER TABLE [dbo].[bai_giang] CHECK CONSTRAINT [FKmadbdlsb30kgmig4g4fo07yjw]
GO
ALTER TABLE [dbo].[bao_cao]  WITH CHECK ADD  CONSTRAINT [FK8hnlhb04u7oqgkqd4auf2nw3n] FOREIGN KEY([ma_nhan_vien])
REFERENCES [dbo].[nhan_vien] ([ma_nhan_vien])
GO
ALTER TABLE [dbo].[bao_cao] CHECK CONSTRAINT [FK8hnlhb04u7oqgkqd4auf2nw3n]
GO
ALTER TABLE [dbo].[chi_tiet_nhan_vien]  WITH CHECK ADD  CONSTRAINT [FK6bit8ow12aqn33m7hl9ujocuk] FOREIGN KEY([ma_nhan_vien])
REFERENCES [dbo].[nhan_vien] ([ma_nhan_vien])
GO
ALTER TABLE [dbo].[chi_tiet_nhan_vien] CHECK CONSTRAINT [FK6bit8ow12aqn33m7hl9ujocuk]
GO
ALTER TABLE [dbo].[nhan_vien]  WITH CHECK ADD  CONSTRAINT [FKa11n5xkhbcsd4oyomblnu06r2] FOREIGN KEY([ma_phong_ban])
REFERENCES [dbo].[phong_ban] ([ma_phong_ban])
GO
ALTER TABLE [dbo].[nhan_vien] CHECK CONSTRAINT [FKa11n5xkhbcsd4oyomblnu06r2]
GO
ALTER TABLE [dbo].[sinh_vien_mon_hoc]  WITH CHECK ADD  CONSTRAINT [FKge6pa2ht3m8vb7xk683d5pq0o] FOREIGN KEY([ma_mon_hoc])
REFERENCES [dbo].[mon_hoc] ([ma_mon_hoc])
GO
ALTER TABLE [dbo].[sinh_vien_mon_hoc] CHECK CONSTRAINT [FKge6pa2ht3m8vb7xk683d5pq0o]
GO
ALTER TABLE [dbo].[sinh_vien_mon_hoc]  WITH CHECK ADD  CONSTRAINT [FKntd5pdwwa0wrekn7r63a10198] FOREIGN KEY([ma_sinh_vien])
REFERENCES [dbo].[sinh_vien] ([ma_sinh_vien])
GO
ALTER TABLE [dbo].[sinh_vien_mon_hoc] CHECK CONSTRAINT [FKntd5pdwwa0wrekn7r63a10198]
GO
