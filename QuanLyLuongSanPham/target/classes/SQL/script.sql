USE [QuanLy_LuongSanPham]
GO
/****** Object:  Table [dbo].[BANGLUONGCONGNHAN]    Script Date: 5/30/2023 5:03:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BANGLUONGCONGNHAN](
	[MaPhieuLuong] [varchar](11) NOT NULL,
	[MaCongNhan] [varchar](8) NOT NULL,
	[NamLuong] [int] NOT NULL,
	[ThangLuong] [int] NOT NULL,
	[SoLuongDaLam] [int] NOT NULL,
	[TongLuong] [float] NOT NULL,
	[NgayLapPhieuLuong]  AS (getdate()),
PRIMARY KEY CLUSTERED 
(
	[MaPhieuLuong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BANGLUONGNHANVIEN]    Script Date: 5/30/2023 5:03:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BANGLUONGNHANVIEN](
	[MaBangLuong] [varchar](11) NOT NULL,
	[MaNhanVien] [varchar](7) NOT NULL,
	[NamLuong] [int] NOT NULL,
	[ThangLuong] [int] NOT NULL,
	[SoNgayLam] [float] NOT NULL,
	[TongLuong] [float] NOT NULL,
	[NgayLapPhieuLuong]  AS (getdate()),
 CONSTRAINT [PK__LUONGNHA__4592D919EED2F696] PRIMARY KEY CLUSTERED 
(
	[MaBangLuong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BANGPHANCONG]    Script Date: 5/30/2023 5:03:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BANGPHANCONG](
	[MaPhanCong] [varchar](9) NOT NULL,
	[MaPhanDoan] [varchar](9) NOT NULL,
	[MaCongNhan] [varchar](8) NOT NULL,
	[SoLuongCanLam] [int] NOT NULL,
	[NgayPhanCong] [date] NOT NULL,
	[NgayHoanThanh] [date] NOT NULL,
	[TrangThai] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPhanCong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CHAMCONGCONGNHAN]    Script Date: 5/30/2023 5:03:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CHAMCONGCONGNHAN](
	[MaChamCong] [varchar](11) NOT NULL,
	[MaPhanCong] [varchar](9) NOT NULL,
	[SoLuongSanPham] [int] NOT NULL,
	[HeSoLuongCa] [float] NOT NULL,
	[CaLam] [nvarchar](50) NOT NULL,
	[TrangThai] [nvarchar](50) NULL,
	[NgayChamCong]  AS (getdate())
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CHAMCONGNHANVIEN]    Script Date: 5/30/2023 5:03:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CHAMCONGNHANVIEN](
	[MaChamCong] [varchar](11) NOT NULL,
	[MaNhanVien] [varchar](7) NOT NULL,
	[CaLam] [nvarchar](50) NOT NULL,
	[HeSoLuongCa] [float] NOT NULL,
	[TrangThai] [int] NOT NULL,
	[NghiPhep] [int] NOT NULL,
	[GhiChu] [nvarchar](255) NULL,
	[NgayChamCong] [date] NULL,
 CONSTRAINT [PK__CHAMCONG__307331A101F335DE] PRIMARY KEY CLUSTERED 
(
	[MaChamCong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CONGNHAN]    Script Date: 5/30/2023 5:03:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CONGNHAN](
	[MaCongNhan] [varchar](8) NOT NULL,
	[TenCongNhan] [nvarchar](100) NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[GioiTinh] [smallint] NOT NULL,
	[DiaChi] [nvarchar](255) NULL,
	[SoDienThoai] [varchar](50) NULL,
	[Email] [varchar](50) NULL,
	[CMND] [varchar](50) NULL,
	[NgayBatDau] [date] NULL,
	[TayNghe] [nvarchar](100) NULL,
	[TroCap] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaCongNhan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NHANVIEN]    Script Date: 5/30/2023 5:03:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NHANVIEN](
	[MaNhanVien] [varchar](7) NOT NULL,
	[MaPhongBan] [varchar](50) NOT NULL,
	[TenNhanVien] [nvarchar](100) NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[GioiTinh] [smallint] NOT NULL,
	[DiaChi] [nvarchar](255) NULL,
	[SoDienThoai] [varchar](50) NULL,
	[Email] [varchar](50) NULL,
	[CMND] [varchar](50) NULL,
	[NgayBatDau] [date] NULL,
	[ChucVu] [nvarchar](100) NOT NULL,
	[HeSoLuong] [float] NOT NULL,
	[LuongCoBan] [float] NOT NULL,
	[PhuCap] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PHANDOAN]    Script Date: 5/30/2023 5:03:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PHANDOAN](
	[MaPhanDoan] [varchar](9) NOT NULL,
	[TenPhanDoan] [nvarchar](200) NOT NULL,
	[MaSanPham] [varchar](50) NOT NULL,
	[GiaPhanDoan] [float] NOT NULL,
	[PhanDoanYeuCau] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPhanDoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PHONGBAN]    Script Date: 5/30/2023 5:03:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PHONGBAN](
	[MaPhongBan] [varchar](50) NOT NULL,
	[TenPhongBan] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPhongBan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SANPHAM]    Script Date: 5/30/2023 5:03:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SANPHAM](
	[MaSanPham] [varchar](50) NOT NULL,
	[TenSanPham] [nvarchar](200) NOT NULL,
	[LoaiSanPham] [nvarchar](100) NULL,
	[MauSac] [nvarchar](100) NULL,
	[ChatLieu] [nvarchar](100) NULL,
	[SoLuongCanLam] [int] NOT NULL,
	[SoLuongDaLam] [int] NULL,
	[NgayHoanThanh] [date] NOT NULL,
	[TrangThai] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TAIKHOAN]    Script Date: 5/30/2023 5:03:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TAIKHOAN](
	[MaNhanVien] [varchar](7) NOT NULL,
	[MatKhau] [varchar](50) NOT NULL,
 CONSTRAINT [PK__TAIKHOAN__77B2CA473E51E69A] PRIMARY KEY CLUSTERED 
(
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[BANGLUONGCONGNHAN] ([MaPhieuLuong], [MaCongNhan], [NamLuong], [ThangLuong], [SoLuongDaLam], [TongLuong]) VALUES (N'BLCN-000001', N'CN_00001', 2023, 1, 100, 800000)
GO
INSERT [dbo].[BANGLUONGCONGNHAN] ([MaPhieuLuong], [MaCongNhan], [NamLuong], [ThangLuong], [SoLuongDaLam], [TongLuong]) VALUES (N'BLCN-000002', N'CN_00002', 2023, 1, 20, 700000)
GO
INSERT [dbo].[BANGLUONGCONGNHAN] ([MaPhieuLuong], [MaCongNhan], [NamLuong], [ThangLuong], [SoLuongDaLam], [TongLuong]) VALUES (N'BLCN-000003', N'CN_00003', 2023, 1, 30, 700000)
GO
INSERT [dbo].[BANGLUONGCONGNHAN] ([MaPhieuLuong], [MaCongNhan], [NamLuong], [ThangLuong], [SoLuongDaLam], [TongLuong]) VALUES (N'BLCN-000004', N'CN_00004', 2023, 1, 40, 600000)
GO
INSERT [dbo].[BANGLUONGCONGNHAN] ([MaPhieuLuong], [MaCongNhan], [NamLuong], [ThangLuong], [SoLuongDaLam], [TongLuong]) VALUES (N'BLCN-000005', N'CN_00005', 2023, 1, 10, 900000)
GO
INSERT [dbo].[BANGLUONGNHANVIEN] ([MaBangLuong], [MaNhanVien], [NamLuong], [ThangLuong], [SoNgayLam], [TongLuong]) VALUES (N'BLNV-000001', N'NV_0001', 2023, 3, 29, 13500000)
GO
INSERT [dbo].[BANGLUONGNHANVIEN] ([MaBangLuong], [MaNhanVien], [NamLuong], [ThangLuong], [SoNgayLam], [TongLuong]) VALUES (N'BLNV-000002', N'NV_0001', 2023, 1, 10, 5207692.5)
GO
INSERT [dbo].[BANGLUONGNHANVIEN] ([MaBangLuong], [MaNhanVien], [NamLuong], [ThangLuong], [SoNgayLam], [TongLuong]) VALUES (N'BLNV-000003', N'NV_0002', 2023, 1, 10, 10615385)
GO
INSERT [dbo].[BANGLUONGNHANVIEN] ([MaBangLuong], [MaNhanVien], [NamLuong], [ThangLuong], [SoNgayLam], [TongLuong]) VALUES (N'BLNV-000004', N'NV_0003', 2023, 1, 10, 6269231)
GO
INSERT [dbo].[BANGLUONGNHANVIEN] ([MaBangLuong], [MaNhanVien], [NamLuong], [ThangLuong], [SoNgayLam], [TongLuong]) VALUES (N'BLNV-000005', N'NV_0004', 2023, 1, 10, 6269231)
GO
INSERT [dbo].[BANGLUONGNHANVIEN] ([MaBangLuong], [MaNhanVien], [NamLuong], [ThangLuong], [SoNgayLam], [TongLuong]) VALUES (N'BLNV-000006', N'NV_0005', 2023, 1, 10, 6269231)
GO
INSERT [dbo].[BANGLUONGNHANVIEN] ([MaBangLuong], [MaNhanVien], [NamLuong], [ThangLuong], [SoNgayLam], [TongLuong]) VALUES (N'BLNV-000007', N'NV_0006', 2023, 1, 10, 6269231)
GO
INSERT [dbo].[BANGLUONGNHANVIEN] ([MaBangLuong], [MaNhanVien], [NamLuong], [ThangLuong], [SoNgayLam], [TongLuong]) VALUES (N'BLNV-000008', N'NV_0007', 2023, 1, 10, 8492308)
GO
INSERT [dbo].[BANGLUONGNHANVIEN] ([MaBangLuong], [MaNhanVien], [NamLuong], [ThangLuong], [SoNgayLam], [TongLuong]) VALUES (N'BLNV-000009', N'NV_0008', 2023, 1, 10, 5884615.5)
GO
INSERT [dbo].[BANGLUONGNHANVIEN] ([MaBangLuong], [MaNhanVien], [NamLuong], [ThangLuong], [SoNgayLam], [TongLuong]) VALUES (N'BLNV-000010', N'NV_0009', 2023, 1, 10, 5884615.5)
GO
INSERT [dbo].[BANGLUONGNHANVIEN] ([MaBangLuong], [MaNhanVien], [NamLuong], [ThangLuong], [SoNgayLam], [TongLuong]) VALUES (N'BLNV-000011', N'NV_0010', 2023, 1, 10, 5884615.5)
GO
INSERT [dbo].[BANGLUONGNHANVIEN] ([MaBangLuong], [MaNhanVien], [NamLuong], [ThangLuong], [SoNgayLam], [TongLuong]) VALUES (N'BLNV-000012', N'NV_0011', 2023, 1, 8, 18307692)
GO
INSERT [dbo].[BANGPHANCONG] ([MaPhanCong], [MaPhanDoan], [MaCongNhan], [SoLuongCanLam], [NgayPhanCong], [NgayHoanThanh], [TrangThai]) VALUES (N'PC-000001', N'PD-000001', N'CN_00001', 100, CAST(N'2023-10-01' AS Date), CAST(N'2023-11-01' AS Date), N'Chưa hoàn thành')
GO
INSERT [dbo].[BANGPHANCONG] ([MaPhanCong], [MaPhanDoan], [MaCongNhan], [SoLuongCanLam], [NgayPhanCong], [NgayHoanThanh], [TrangThai]) VALUES (N'PC-000002', N'PD-000002', N'CN_00002', 90, CAST(N'2023-10-01' AS Date), CAST(N'2023-11-01' AS Date), N'Chưa hoàn thành')
GO
INSERT [dbo].[BANGPHANCONG] ([MaPhanCong], [MaPhanDoan], [MaCongNhan], [SoLuongCanLam], [NgayPhanCong], [NgayHoanThanh], [TrangThai]) VALUES (N'PC-000003', N'PD-000003', N'CN_00003', 80, CAST(N'2023-10-01' AS Date), CAST(N'2023-11-01' AS Date), N'Chưa hoàn thành')
GO
INSERT [dbo].[BANGPHANCONG] ([MaPhanCong], [MaPhanDoan], [MaCongNhan], [SoLuongCanLam], [NgayPhanCong], [NgayHoanThanh], [TrangThai]) VALUES (N'PC-000004', N'PD-000004', N'CN_00004', 70, CAST(N'2023-10-01' AS Date), CAST(N'2023-11-01' AS Date), N'Chưa hoàn thành')
GO
INSERT [dbo].[BANGPHANCONG] ([MaPhanCong], [MaPhanDoan], [MaCongNhan], [SoLuongCanLam], [NgayPhanCong], [NgayHoanThanh], [TrangThai]) VALUES (N'PC-000005', N'PD-000005', N'CN_00005', 20, CAST(N'2023-10-01' AS Date), CAST(N'2023-11-01' AS Date), N'Chưa hoàn thành')
GO
INSERT [dbo].[CHAMCONGCONGNHAN] ([MaChamCong], [MaPhanCong], [SoLuongSanPham], [HeSoLuongCa], [CaLam], [TrangThai]) VALUES (N'CCCN-000001', N'PC-000001', 90, 1.2, N'Ca Tối', N'Có mặt')
GO
INSERT [dbo].[CHAMCONGCONGNHAN] ([MaChamCong], [MaPhanCong], [SoLuongSanPham], [HeSoLuongCa], [CaLam], [TrangThai]) VALUES (N'CCCN-000001', N'PC-000002', 20, 1.5, N'Ca Tối', N'Có mặt')
GO
INSERT [dbo].[CHAMCONGCONGNHAN] ([MaChamCong], [MaPhanCong], [SoLuongSanPham], [HeSoLuongCa], [CaLam], [TrangThai]) VALUES (N'CCCN-000001', N'PC-000003', 30, 1.5, N'Ca Tối', N'Vắng mặt')
GO
INSERT [dbo].[CHAMCONGCONGNHAN] ([MaChamCong], [MaPhanCong], [SoLuongSanPham], [HeSoLuongCa], [CaLam], [TrangThai]) VALUES (N'CCCN-000001', N'PC-000004', 40, 1.5, N'Ca Tối', N'Vắng mặt')
GO
INSERT [dbo].[CHAMCONGCONGNHAN] ([MaChamCong], [MaPhanCong], [SoLuongSanPham], [HeSoLuongCa], [CaLam], [TrangThai]) VALUES (N'CCCN-000001', N'PC-000005', 10, 1.5, N'Ca Tối', N'Có mặt')
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000001', N'NV_0001', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-01' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000002', N'NV_0002', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-01' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000003', N'NV_0003', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-01' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000004', N'NV_0004', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-01' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000005', N'NV_0005', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-01' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000006', N'NV_0006', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-01' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000007', N'NV_0007', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-01' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000008', N'NV_0008', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-01' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000009', N'NV_0009', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-01' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000010', N'NV_0010', N'Ca sáng', 1, 0, 1, N'', CAST(N'2023-01-01' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000011', N'NV_0001', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-01' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000012', N'NV_0002', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-01' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000013', N'NV_0003', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-01' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000014', N'NV_0004', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-01' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000015', N'NV_0005', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-01' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000016', N'NV_0006', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-01' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000017', N'NV_0007', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-01' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000018', N'NV_0008', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-01' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000019', N'NV_0009', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-01' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000020', N'NV_0010', N'Ca chiều', 1, 0, 1, N'', CAST(N'2023-01-01' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000021', N'NV_0001', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-02' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000022', N'NV_0002', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-02' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000023', N'NV_0003', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-02' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000024', N'NV_0004', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-02' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000025', N'NV_0005', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-02' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000026', N'NV_0006', N'Ca sáng', 1, 0, 1, N'', CAST(N'2023-01-02' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000027', N'NV_0007', N'Ca sáng', 1, 0, 1, N'', CAST(N'2023-01-02' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000028', N'NV_0008', N'Ca sáng', 1, 0, 1, N'', CAST(N'2023-01-02' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000029', N'NV_0009', N'Ca sáng', 1, 0, 1, N'', CAST(N'2023-01-02' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000030', N'NV_0010', N'Ca sáng', 1, 0, 1, N'', CAST(N'2023-01-02' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000031', N'NV_0011', N'Ca sáng', 1, 0, 1, N'', CAST(N'2023-01-02' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000032', N'NV_0001', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-02' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000033', N'NV_0002', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-02' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000034', N'NV_0003', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-02' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000035', N'NV_0004', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-02' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000036', N'NV_0005', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-02' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000037', N'NV_0006', N'Ca chiều', 1, 0, 1, N'', CAST(N'2023-01-02' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000038', N'NV_0007', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-02' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000039', N'NV_0008', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-02' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000040', N'NV_0009', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-02' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000041', N'NV_0010', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-02' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000042', N'NV_0011', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-02' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000043', N'NV_0002', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-03' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000044', N'NV_0003', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-03' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000045', N'NV_0004', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-03' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000046', N'NV_0005', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-03' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000047', N'NV_0006', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-03' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000048', N'NV_0007', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-03' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000049', N'NV_0008', N'Ca sáng', 1, 0, 1, N'', CAST(N'2023-01-03' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000050', N'NV_0009', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-03' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000051', N'NV_0010', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-03' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000052', N'NV_0011', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-03' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000053', N'NV_0002', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-03' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000054', N'NV_0003', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-03' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000055', N'NV_0004', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-03' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000056', N'NV_0005', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-03' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000057', N'NV_0006', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-03' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000058', N'NV_0007', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-03' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000059', N'NV_0008', N'Ca chiều', 1, 0, 1, N'', CAST(N'2023-01-03' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000060', N'NV_0009', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-03' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000061', N'NV_0010', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-03' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000062', N'NV_0011', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-03' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000063', N'NV_0001', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-04' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000064', N'NV_0002', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-04' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000065', N'NV_0003', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-04' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000066', N'NV_0004', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-04' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000067', N'NV_0005', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-04' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000068', N'NV_0006', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-04' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000069', N'NV_0007', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-04' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000070', N'NV_0008', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-04' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000071', N'NV_0009', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-04' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000072', N'NV_0010', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-04' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000073', N'NV_0001', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-04' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000074', N'NV_0002', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-04' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000075', N'NV_0003', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-04' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000076', N'NV_0004', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-04' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000077', N'NV_0005', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-04' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000078', N'NV_0006', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-04' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000079', N'NV_0007', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-04' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000080', N'NV_0008', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-04' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000081', N'NV_0009', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-04' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000082', N'NV_0010', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-04' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000083', N'NV_0001', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-05' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000084', N'NV_0002', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-05' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000085', N'NV_0003', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-05' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000086', N'NV_0004', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-05' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000087', N'NV_0005', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-05' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000088', N'NV_0006', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-05' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000089', N'NV_0007', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-05' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000090', N'NV_0008', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-05' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000091', N'NV_0009', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-05' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000092', N'NV_0010', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-05' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000093', N'NV_0011', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-05' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000094', N'NV_0001', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-05' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000095', N'NV_0002', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-05' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000096', N'NV_0003', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-05' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000097', N'NV_0004', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-05' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000098', N'NV_0005', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-05' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000099', N'NV_0006', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-05' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000100', N'NV_0007', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-05' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000101', N'NV_0008', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-05' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000102', N'NV_0009', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-05' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000103', N'NV_0010', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-05' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000104', N'NV_0011', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-05' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000105', N'NV_0001', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-06' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000106', N'NV_0002', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-06' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000107', N'NV_0003', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-06' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000108', N'NV_0004', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-06' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000109', N'NV_0005', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-06' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000110', N'NV_0006', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-06' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000111', N'NV_0007', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-06' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000112', N'NV_0008', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-06' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000113', N'NV_0009', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-06' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000114', N'NV_0010', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-06' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000115', N'NV_0011', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-06' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000116', N'NV_0001', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-06' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000117', N'NV_0002', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-06' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000118', N'NV_0003', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-06' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000119', N'NV_0004', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-06' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000120', N'NV_0005', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-06' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000121', N'NV_0006', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-06' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000122', N'NV_0007', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-06' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000123', N'NV_0008', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-06' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000124', N'NV_0009', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-06' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000125', N'NV_0010', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-06' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000126', N'NV_0011', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-06' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000127', N'NV_0001', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-07' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000128', N'NV_0002', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-07' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000129', N'NV_0003', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-07' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000130', N'NV_0004', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-07' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000131', N'NV_0005', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-07' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000132', N'NV_0006', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-07' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000133', N'NV_0007', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-07' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000134', N'NV_0008', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-07' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000135', N'NV_0009', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-07' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000136', N'NV_0010', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-07' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000137', N'NV_0011', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-07' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000138', N'NV_0001', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-07' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000139', N'NV_0002', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-07' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000140', N'NV_0003', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-07' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000141', N'NV_0004', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-07' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000142', N'NV_0005', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-07' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000143', N'NV_0006', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-07' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000144', N'NV_0007', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-07' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000145', N'NV_0008', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-07' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000146', N'NV_0009', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-07' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000147', N'NV_0010', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-07' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000148', N'NV_0011', N'Ca chiều', 1, 0, 1, N'', CAST(N'2023-01-07' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000149', N'NV_0001', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-08' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000150', N'NV_0002', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-08' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000151', N'NV_0003', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-08' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000152', N'NV_0004', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-08' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000153', N'NV_0005', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-08' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000154', N'NV_0006', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-08' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000155', N'NV_0007', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-08' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000156', N'NV_0008', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-08' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000157', N'NV_0009', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-08' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000158', N'NV_0010', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-08' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000159', N'NV_0001', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-08' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000160', N'NV_0002', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-08' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000161', N'NV_0003', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-08' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000162', N'NV_0004', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-08' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000163', N'NV_0005', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-08' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000164', N'NV_0006', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-08' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000165', N'NV_0007', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-08' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000166', N'NV_0008', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-08' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000167', N'NV_0009', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-08' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000168', N'NV_0010', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-08' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000169', N'NV_0001', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-09' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000170', N'NV_0002', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-09' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000171', N'NV_0003', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-09' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000172', N'NV_0004', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-09' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000173', N'NV_0005', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-09' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000174', N'NV_0006', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-09' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000175', N'NV_0007', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-09' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000176', N'NV_0008', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-09' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000177', N'NV_0009', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-09' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000178', N'NV_0010', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-09' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000179', N'NV_0011', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-09' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000180', N'NV_0001', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-09' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000181', N'NV_0002', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-09' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000182', N'NV_0003', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-09' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000183', N'NV_0004', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-09' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000184', N'NV_0005', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-09' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000185', N'NV_0006', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-09' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000186', N'NV_0007', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-09' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000187', N'NV_0008', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-09' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000188', N'NV_0009', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-09' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000189', N'NV_0010', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-09' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000190', N'NV_0011', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-09' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000191', N'NV_0001', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-10' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000192', N'NV_0002', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-10' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000193', N'NV_0003', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-10' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000194', N'NV_0004', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-10' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000195', N'NV_0005', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-10' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000196', N'NV_0006', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-10' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000197', N'NV_0007', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-10' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000198', N'NV_0008', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-10' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000199', N'NV_0009', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-10' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000200', N'NV_0010', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-10' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000201', N'NV_0011', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-10' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000202', N'NV_0001', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-10' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000203', N'NV_0002', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-10' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000204', N'NV_0003', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-10' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000205', N'NV_0004', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-10' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000206', N'NV_0005', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-10' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000207', N'NV_0006', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-10' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000208', N'NV_0007', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-10' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000209', N'NV_0008', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-10' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000210', N'NV_0009', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-10' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000211', N'NV_0010', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-10' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000212', N'NV_0011', N'Ca chiều', 1, 1, 0, N'', CAST(N'2023-01-10' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000213', N'NV_0001', N'Ch? Nh?t', 1.2, 1, 0, NULL, CAST(N'2023-01-10' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000214', N'NV_0001', N'Ch? Nh?t', 1.2, 1, 0, NULL, CAST(N'2023-01-10' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000215', N'NV_0001', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-11' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000216', N'NV_0011', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-11' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000217', N'NV_0011', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-01-11' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000218', N'NV_0002', N'Ca sáng', 1, 0, 1, N'Bị bệnh đột xuất', CAST(N'2023-04-17' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000219', N'NV_0001', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-04-18' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000220', N'NV_0002', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-04-18' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000221', N'NV_0003', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-04-18' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000222', N'NV_0004', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-04-18' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000223', N'NV_0005', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-04-18' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000224', N'NV_0006', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-04-18' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000225', N'NV_0007', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-04-18' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000226', N'NV_0008', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-04-18' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000227', N'NV_0009', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-04-18' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000228', N'NV_0010', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-04-18' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000229', N'NV_0011', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-04-18' AS Date))
GO
INSERT [dbo].[CHAMCONGNHANVIEN] ([MaChamCong], [MaNhanVien], [CaLam], [HeSoLuongCa], [TrangThai], [NghiPhep], [GhiChu], [NgayChamCong]) VALUES (N'CCNV-000230', N'NV_0001', N'Ca sáng', 1, 1, 0, N'', CAST(N'2023-04-19' AS Date))
GO
INSERT [dbo].[CONGNHAN] ([MaCongNhan], [TenCongNhan], [NgaySinh], [GioiTinh], [DiaChi], [SoDienThoai], [Email], [CMND], [NgayBatDau], [TayNghe], [TroCap]) VALUES (N'CN_00001', N'Nguyễn Trọng Hữu', CAST(N'2002-01-23' AS Date), 1, N'Đồng Xoài - Bình Phước', N'0339392379', N'tronghuu123@gmail.com', N'215470319909', CAST(N'2022-10-01' AS Date), N'Giỏi', 0)
GO
INSERT [dbo].[CONGNHAN] ([MaCongNhan], [TenCongNhan], [NgaySinh], [GioiTinh], [DiaChi], [SoDienThoai], [Email], [CMND], [NgayBatDau], [TayNghe], [TroCap]) VALUES (N'CN_00002', N'Phan Lương Trung Chánh', CAST(N'2002-01-01' AS Date), 1, N'Tiền Giang', N'0972456789', N'trungchanh@gmail.com', N'215470319902', CAST(N'2023-04-01' AS Date), N'Trung Bình', 0)
GO
INSERT [dbo].[CONGNHAN] ([MaCongNhan], [TenCongNhan], [NgaySinh], [GioiTinh], [DiaChi], [SoDienThoai], [Email], [CMND], [NgayBatDau], [TayNghe], [TroCap]) VALUES (N'CN_00003', N'Trần Quang Huy', CAST(N'2002-01-01' AS Date), 1, N'Bình Định', N'0972412345', N'quanghuy@gmail.com', N'215470319901', CAST(N'2023-04-01' AS Date), N'Khá', 0)
GO
INSERT [dbo].[CONGNHAN] ([MaCongNhan], [TenCongNhan], [NgaySinh], [GioiTinh], [DiaChi], [SoDienThoai], [Email], [CMND], [NgayBatDau], [TayNghe], [TroCap]) VALUES (N'CN_00004', N'Nguyễn Minh Duy', CAST(N'2002-11-12' AS Date), 1, N'Bình Dương', N'0972409858', N'minhduy@gmail.com', N'215470318807', CAST(N'2023-04-01' AS Date), N'Giỏi', 1)
GO
INSERT [dbo].[CONGNHAN] ([MaCongNhan], [TenCongNhan], [NgaySinh], [GioiTinh], [DiaChi], [SoDienThoai], [Email], [CMND], [NgayBatDau], [TayNghe], [TroCap]) VALUES (N'CN_00005', N'Nguyễn Văn Vằn', CAST(N'2002-06-05' AS Date), 1, N'Bình Dương', N'0756409858', N'vanvan@gmail.com', N'215470316790', CAST(N'2023-04-01' AS Date), N'Giỏi', 2)
GO
INSERT [dbo].[NHANVIEN] ([MaNhanVien], [MaPhongBan], [TenNhanVien], [NgaySinh], [GioiTinh], [DiaChi], [SoDienThoai], [Email], [CMND], [NgayBatDau], [ChucVu], [HeSoLuong], [LuongCoBan], [PhuCap]) VALUES (N'NV_0001', N'PB_KeToan', N'Trần Quang Huy', CAST(N'2002-07-26' AS Date), 1, N'Phù Cát - Bình Định', N'0357391270', N'tranquanghuyit09@gmail.com', N'214470018', CAST(N'2022-01-01' AS Date), N'Trưởng phòng', 1.2, 12000000, 500000)
GO
INSERT [dbo].[NHANVIEN] ([MaNhanVien], [MaPhongBan], [TenNhanVien], [NgaySinh], [GioiTinh], [DiaChi], [SoDienThoai], [Email], [CMND], [NgayBatDau], [ChucVu], [HeSoLuong], [LuongCoBan], [PhuCap]) VALUES (N'NV_0002', N'PB_Marketing', N'Nguyễn Diệp Anh', CAST(N'1999-06-10' AS Date), 0, N'Cầu Giấy, Hà Nội', N'0924608193', N'anhnd@gmail.com', N'035301001459', CAST(N'2022-02-04' AS Date), N'Quản lý', 1.2, 25000000, 1000000)
GO
INSERT [dbo].[NHANVIEN] ([MaNhanVien], [MaPhongBan], [TenNhanVien], [NgaySinh], [GioiTinh], [DiaChi], [SoDienThoai], [Email], [CMND], [NgayBatDau], [ChucVu], [HeSoLuong], [LuongCoBan], [PhuCap]) VALUES (N'NV_0003', N'PB_Marketing', N'Trần Nam Anh', CAST(N'1989-09-11' AS Date), 1, N'Hoàng Mai, Hà Nội', N'0962342550', N'anhnt@gmail.com', N'035301001460', CAST(N'2020-03-12' AS Date), N'Nhân viên', 1, 15000000, 500000)
GO
INSERT [dbo].[NHANVIEN] ([MaNhanVien], [MaPhongBan], [TenNhanVien], [NgaySinh], [GioiTinh], [DiaChi], [SoDienThoai], [Email], [CMND], [NgayBatDau], [ChucVu], [HeSoLuong], [LuongCoBan], [PhuCap]) VALUES (N'NV_0004', N'PB_Marketing', N'Hoàng Ngọc Bách', CAST(N'2000-08-12' AS Date), 1, N'Thường Tín, Hà Nội', N'0834082001', N'bachnh@gmail.com', N'035301001461', CAST(N'2022-06-16' AS Date), N'Nhân viên', 1, 15000000, 500000)
GO
INSERT [dbo].[NHANVIEN] ([MaNhanVien], [MaPhongBan], [TenNhanVien], [NgaySinh], [GioiTinh], [DiaChi], [SoDienThoai], [Email], [CMND], [NgayBatDau], [ChucVu], [HeSoLuong], [LuongCoBan], [PhuCap]) VALUES (N'NV_0005', N'PB_Marketing', N'Nguyễn Thị Kim Dung', CAST(N'1999-06-14' AS Date), 0, N'Thanh Xuân, Hà Nội', N'0163533789', N'dungktn@gmail.com', N'035301261462', CAST(N'2021-11-27' AS Date), N'Nhân viên', 1, 15000000, 500000)
GO
INSERT [dbo].[NHANVIEN] ([MaNhanVien], [MaPhongBan], [TenNhanVien], [NgaySinh], [GioiTinh], [DiaChi], [SoDienThoai], [Email], [CMND], [NgayBatDau], [ChucVu], [HeSoLuong], [LuongCoBan], [PhuCap]) VALUES (N'NV_0006', N'PB_Marketing', N'Phạm Hồng Đăng', CAST(N'1998-05-13' AS Date), 1, N'Thường Tín, Hà Nội', N'0984476509', N'danghp@gmail.com', N'035301001462', CAST(N'2022-03-11' AS Date), N'Nhân viên', 1, 15000000, 500000)
GO
INSERT [dbo].[NHANVIEN] ([MaNhanVien], [MaPhongBan], [TenNhanVien], [NgaySinh], [GioiTinh], [DiaChi], [SoDienThoai], [Email], [CMND], [NgayBatDau], [ChucVu], [HeSoLuong], [LuongCoBan], [PhuCap]) VALUES (N'NV_0007', N'PB_HanhChinh', N'Trần Ngọc Hà', CAST(N'1990-04-16' AS Date), 0, N'Thanh Xuân, Hà Nội', N'0924655434', N'hatn@gmai.com', N'047301001465', CAST(N'2022-05-11' AS Date), N'Quản lý', 1.2, 20000000, 800000)
GO
INSERT [dbo].[NHANVIEN] ([MaNhanVien], [MaPhongBan], [TenNhanVien], [NgaySinh], [GioiTinh], [DiaChi], [SoDienThoai], [Email], [CMND], [NgayBatDau], [ChucVu], [HeSoLuong], [LuongCoBan], [PhuCap]) VALUES (N'NV_0008', N'PB_HanhChinh', N'Đào Minh Hạnh', CAST(N'1997-11-15' AS Date), 0, N'Hoàn Kiếm, Hà Nội', N'0941688538', N'hanhmd@gmail.com', N'035301001466', CAST(N'2021-09-06' AS Date), N'Nhân Viên', 1, 14000000, 500000)
GO
INSERT [dbo].[NHANVIEN] ([MaNhanVien], [MaPhongBan], [TenNhanVien], [NgaySinh], [GioiTinh], [DiaChi], [SoDienThoai], [Email], [CMND], [NgayBatDau], [ChucVu], [HeSoLuong], [LuongCoBan], [PhuCap]) VALUES (N'NV_0009', N'PB_HanhChinh', N'Đỗ Quốc Hưng', CAST(N'2000-06-17' AS Date), 1, N'Hà Đông, Hà Nội', N'0162765429', N'hungqd@gmail.com', N'035301001467', CAST(N'2021-11-12' AS Date), N'Nhân viên', 1, 14000000, 500000)
GO
INSERT [dbo].[NHANVIEN] ([MaNhanVien], [MaPhongBan], [TenNhanVien], [NgaySinh], [GioiTinh], [DiaChi], [SoDienThoai], [Email], [CMND], [NgayBatDau], [ChucVu], [HeSoLuong], [LuongCoBan], [PhuCap]) VALUES (N'NV_0010', N'PB_HanhChinh', N'Lê Phương Liên', CAST(N'1999-07-11' AS Date), 0, N'Thanh Xuân, Hà Nội', N'0924655435', N'hatn@gmai.com', N'035301001468', CAST(N'2021-11-10' AS Date), N'Nhân viên', 1, 14000000, 500000)
GO
INSERT [dbo].[NHANVIEN] ([MaNhanVien], [MaPhongBan], [TenNhanVien], [NgaySinh], [GioiTinh], [DiaChi], [SoDienThoai], [Email], [CMND], [NgayBatDau], [ChucVu], [HeSoLuong], [LuongCoBan], [PhuCap]) VALUES (N'NV_0011', N'PB_HanhChinh', N'Nguyễn Anh Mai', CAST(N'1989-08-04' AS Date), 0, N'Cầu Giấy, Hà Nội', N'0924655437', N'maianhnguyen@gmai.com', N'035301001469', CAST(N'2021-11-13' AS Date), N'Nhân viên', 1, 14000000, 500000)
GO
INSERT [dbo].[PHANDOAN] ([MaPhanDoan], [TenPhanDoan], [MaSanPham], [GiaPhanDoan], [PhanDoanYeuCau]) VALUES (N'PD-000001', N'Cắt khuôn', N'SP_Ghe', 20000, N'Không')
GO
INSERT [dbo].[PHANDOAN] ([MaPhanDoan], [TenPhanDoan], [MaSanPham], [GiaPhanDoan], [PhanDoanYeuCau]) VALUES (N'PD-000002', N'Lắp ráp', N'SP_Ghe', 25000, N'C?t khuôn')
GO
INSERT [dbo].[PHANDOAN] ([MaPhanDoan], [TenPhanDoan], [MaSanPham], [GiaPhanDoan], [PhanDoanYeuCau]) VALUES (N'PD-000003', N'Sơn màu', N'SP_Ghe', 30000, N'L?p ráp')
GO
INSERT [dbo].[PHANDOAN] ([MaPhanDoan], [TenPhanDoan], [MaSanPham], [GiaPhanDoan], [PhanDoanYeuCau]) VALUES (N'PD-000004', N'Vẽ họa tiết', N'SP_Ghe', 30000, N'Son màu')
GO
INSERT [dbo].[PHANDOAN] ([MaPhanDoan], [TenPhanDoan], [MaSanPham], [GiaPhanDoan], [PhanDoanYeuCau]) VALUES (N'PD-000005', N'Đóng gói', N'SP_Ghe', 10000, N'V? h?a ti?t')
GO
INSERT [dbo].[PHONGBAN] ([MaPhongBan], [TenPhongBan]) VALUES (N'PB_CSKH', N'Phòng CSKH')
GO
INSERT [dbo].[PHONGBAN] ([MaPhongBan], [TenPhongBan]) VALUES (N'PB_HanhChinh', N'Phòng Hành chính')
GO
INSERT [dbo].[PHONGBAN] ([MaPhongBan], [TenPhongBan]) VALUES (N'PB_KeToan', N'Phòng Kế toán')
GO
INSERT [dbo].[PHONGBAN] ([MaPhongBan], [TenPhongBan]) VALUES (N'PB_KiemToan', N'Phòng Kiểm toán')
GO
INSERT [dbo].[PHONGBAN] ([MaPhongBan], [TenPhongBan]) VALUES (N'PB_KinhDoanh', N'Phòng Kinh doanh')
GO
INSERT [dbo].[PHONGBAN] ([MaPhongBan], [TenPhongBan]) VALUES (N'PB_Marketing', N'Phòng Marketing')
GO
INSERT [dbo].[PHONGBAN] ([MaPhongBan], [TenPhongBan]) VALUES (N'PB_NhanSu', N'Phòng Nhân sự')
GO
INSERT [dbo].[PHONGBAN] ([MaPhongBan], [TenPhongBan]) VALUES (N'PB_PhatTrienSanPham', N'Phòng Phát triển Sản phẩm')
GO
INSERT [dbo].[SANPHAM] ([MaSanPham], [TenSanPham], [LoaiSanPham], [MauSac], [ChatLieu], [SoLuongCanLam], [SoLuongDaLam], [NgayHoanThanh], [TrangThai]) VALUES (N'SP_Ghe', N'Ghế Tựa', N'Ghế', N'Vàng', N'Gỗ', 1000, 1000, CAST(N'2023-07-30' AS Date), N'Hoàn thành')
GO
INSERT [dbo].[SANPHAM] ([MaSanPham], [TenSanPham], [LoaiSanPham], [MauSac], [ChatLieu], [SoLuongCanLam], [SoLuongDaLam], [NgayHoanThanh], [TrangThai]) VALUES (N'SP_KeSach', N'Kệ sách', N'Kệ', N'Nâu', N'Gỗ', 1000, 200, CAST(N'2023-07-30' AS Date), N'Chưa hoàn thành')
GO
INSERT [dbo].[SANPHAM] ([MaSanPham], [TenSanPham], [LoaiSanPham], [MauSac], [ChatLieu], [SoLuongCanLam], [SoLuongDaLam], [NgayHoanThanh], [TrangThai]) VALUES (N'SP_TuAo', N'Tủ áo', N'Tủ', N'Vàng', N'Gỗ', 1000, 70, CAST(N'2023-07-30' AS Date), N'Chưa hoàn thành')
GO
INSERT [dbo].[SANPHAM] ([MaSanPham], [TenSanPham], [LoaiSanPham], [MauSac], [ChatLieu], [SoLuongCanLam], [SoLuongDaLam], [NgayHoanThanh], [TrangThai]) VALUES (N'SP_TuLanh', N'Tủ lạnh', N'Tủ', N'Đỏ', N'Sắt', 1000, 900, CAST(N'2023-07-30' AS Date), N'Chưa hoàn thành')
GO
INSERT [dbo].[TAIKHOAN] ([MaNhanVien], [MatKhau]) VALUES (N'NV_0001', N'Quanghuy09.')
GO
INSERT [dbo].[TAIKHOAN] ([MaNhanVien], [MatKhau]) VALUES (N'NV_0002', N'Quanghuy1')
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__BANGLUON__E18E26060C811E47]    Script Date: 5/30/2023 5:03:38 PM ******/
ALTER TABLE [dbo].[BANGLUONGCONGNHAN] ADD UNIQUE NONCLUSTERED 
(
	[MaPhieuLuong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__LUONGNHA__4592D9186726BA19]    Script Date: 5/30/2023 5:03:38 PM ******/
ALTER TABLE [dbo].[BANGLUONGNHANVIEN] ADD  CONSTRAINT [UQ__LUONGNHA__4592D9186726BA19] UNIQUE NONCLUSTERED 
(
	[MaBangLuong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__BANGPHAN__C279D917EB219BA3]    Script Date: 5/30/2023 5:03:38 PM ******/
ALTER TABLE [dbo].[BANGPHANCONG] ADD UNIQUE NONCLUSTERED 
(
	[MaPhanCong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [CK_CHAMCONGCONGNHAN]    Script Date: 5/30/2023 5:03:38 PM ******/
ALTER TABLE [dbo].[CHAMCONGCONGNHAN] ADD  CONSTRAINT [CK_CHAMCONGCONGNHAN] UNIQUE NONCLUSTERED 
(
	[MaChamCong] ASC,
	[MaPhanCong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__CHAMCONG__307331A0028956E2]    Script Date: 5/30/2023 5:03:38 PM ******/
ALTER TABLE [dbo].[CHAMCONGNHANVIEN] ADD  CONSTRAINT [UQ__CHAMCONG__307331A0028956E2] UNIQUE NONCLUSTERED 
(
	[MaChamCong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__CONGNHAN__3DD895CB9FADEC9D]    Script Date: 5/30/2023 5:03:38 PM ******/
ALTER TABLE [dbo].[CONGNHAN] ADD UNIQUE NONCLUSTERED 
(
	[MaCongNhan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__NHANVIEN__77B2CA46E96FC469]    Script Date: 5/30/2023 5:03:38 PM ******/
ALTER TABLE [dbo].[NHANVIEN] ADD UNIQUE NONCLUSTERED 
(
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__PHANDOAN__CABFB537D859C51C]    Script Date: 5/30/2023 5:03:38 PM ******/
ALTER TABLE [dbo].[PHANDOAN] ADD UNIQUE NONCLUSTERED 
(
	[MaPhanDoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__SANPHAM__FAC7442C765E9185]    Script Date: 5/30/2023 5:03:38 PM ******/
ALTER TABLE [dbo].[SANPHAM] ADD UNIQUE NONCLUSTERED 
(
	[MaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[BANGLUONGCONGNHAN]  WITH CHECK ADD FOREIGN KEY([MaCongNhan])
REFERENCES [dbo].[CONGNHAN] ([MaCongNhan])
GO
ALTER TABLE [dbo].[BANGLUONGNHANVIEN]  WITH CHECK ADD  CONSTRAINT [FK__LUONGNHAN__MaNha__38996AB5] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NHANVIEN] ([MaNhanVien])
GO
ALTER TABLE [dbo].[BANGLUONGNHANVIEN] CHECK CONSTRAINT [FK__LUONGNHAN__MaNha__38996AB5]
GO
ALTER TABLE [dbo].[BANGPHANCONG]  WITH CHECK ADD FOREIGN KEY([MaCongNhan])
REFERENCES [dbo].[CONGNHAN] ([MaCongNhan])
GO
ALTER TABLE [dbo].[BANGPHANCONG]  WITH CHECK ADD FOREIGN KEY([MaPhanDoan])
REFERENCES [dbo].[PHANDOAN] ([MaPhanDoan])
GO
ALTER TABLE [dbo].[CHAMCONGCONGNHAN]  WITH CHECK ADD FOREIGN KEY([MaPhanCong])
REFERENCES [dbo].[BANGPHANCONG] ([MaPhanCong])
GO
ALTER TABLE [dbo].[CHAMCONGNHANVIEN]  WITH CHECK ADD  CONSTRAINT [FK__CHAMCONGN__MaNha__52593CB8] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NHANVIEN] ([MaNhanVien])
GO
ALTER TABLE [dbo].[CHAMCONGNHANVIEN] CHECK CONSTRAINT [FK__CHAMCONGN__MaNha__52593CB8]
GO
ALTER TABLE [dbo].[NHANVIEN]  WITH CHECK ADD FOREIGN KEY([MaPhongBan])
REFERENCES [dbo].[PHONGBAN] ([MaPhongBan])
GO
ALTER TABLE [dbo].[PHANDOAN]  WITH CHECK ADD FOREIGN KEY([MaSanPham])
REFERENCES [dbo].[SANPHAM] ([MaSanPham])
GO
ALTER TABLE [dbo].[TAIKHOAN]  WITH CHECK ADD  CONSTRAINT [FK__TAIKHOAN__MatKha__32E0915F] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NHANVIEN] ([MaNhanVien])
GO
ALTER TABLE [dbo].[TAIKHOAN] CHECK CONSTRAINT [FK__TAIKHOAN__MatKha__32E0915F]
GO
ALTER TABLE [dbo].[BANGLUONGCONGNHAN]  WITH CHECK ADD CHECK  (([MaPhieuLuong] like 'BLCN-[0-9][0-9][0-9][0-9][0-9][1-9]'))
GO
ALTER TABLE [dbo].[BANGLUONGCONGNHAN]  WITH CHECK ADD  CONSTRAINT [CK_NamLuong_2] CHECK  (([NamLuong]>(0)))
GO
ALTER TABLE [dbo].[BANGLUONGCONGNHAN] CHECK CONSTRAINT [CK_NamLuong_2]
GO
ALTER TABLE [dbo].[BANGLUONGCONGNHAN]  WITH CHECK ADD  CONSTRAINT [CK_SoLuongDaLam_2] CHECK  (([SoLuongDaLam]>=(0)))
GO
ALTER TABLE [dbo].[BANGLUONGCONGNHAN] CHECK CONSTRAINT [CK_SoLuongDaLam_2]
GO
ALTER TABLE [dbo].[BANGLUONGCONGNHAN]  WITH CHECK ADD  CONSTRAINT [CK_ThangLuong_2] CHECK  (([ThangLuong]>(0)))
GO
ALTER TABLE [dbo].[BANGLUONGCONGNHAN] CHECK CONSTRAINT [CK_ThangLuong_2]
GO
ALTER TABLE [dbo].[BANGLUONGCONGNHAN]  WITH CHECK ADD  CONSTRAINT [CK_TongLuong_LonHon0_2] CHECK  (([TongLuong]>=(0.0)))
GO
ALTER TABLE [dbo].[BANGLUONGCONGNHAN] CHECK CONSTRAINT [CK_TongLuong_LonHon0_2]
GO
ALTER TABLE [dbo].[BANGLUONGNHANVIEN]  WITH CHECK ADD  CONSTRAINT [CK__LUONGNHAN__MaBan__398D8EEE] CHECK  (([MaBangLuong] like 'BLNV-[0-9][0-9][0-9][0-9][0-9][0-9]'))
GO
ALTER TABLE [dbo].[BANGLUONGNHANVIEN] CHECK CONSTRAINT [CK__LUONGNHAN__MaBan__398D8EEE]
GO
ALTER TABLE [dbo].[BANGLUONGNHANVIEN]  WITH CHECK ADD  CONSTRAINT [CK_NamLuong] CHECK  (([NamLuong]>(0)))
GO
ALTER TABLE [dbo].[BANGLUONGNHANVIEN] CHECK CONSTRAINT [CK_NamLuong]
GO
ALTER TABLE [dbo].[BANGLUONGNHANVIEN]  WITH CHECK ADD  CONSTRAINT [CK_SoNgayLam] CHECK  (([SoNgayLam]>=(0)))
GO
ALTER TABLE [dbo].[BANGLUONGNHANVIEN] CHECK CONSTRAINT [CK_SoNgayLam]
GO
ALTER TABLE [dbo].[BANGLUONGNHANVIEN]  WITH CHECK ADD  CONSTRAINT [CK_ThangLuong] CHECK  (([ThangLuong]>(0)))
GO
ALTER TABLE [dbo].[BANGLUONGNHANVIEN] CHECK CONSTRAINT [CK_ThangLuong]
GO
ALTER TABLE [dbo].[BANGLUONGNHANVIEN]  WITH CHECK ADD  CONSTRAINT [CK_TongLuong_GreaterThanOrEqualZero] CHECK  (([TongLuong]>=(0.0)))
GO
ALTER TABLE [dbo].[BANGLUONGNHANVIEN] CHECK CONSTRAINT [CK_TongLuong_GreaterThanOrEqualZero]
GO
ALTER TABLE [dbo].[BANGPHANCONG]  WITH CHECK ADD  CONSTRAINT [CHK_NgayHoanThanh_2] CHECK  (([NgayHoanThanh]>[NgayPhanCong]))
GO
ALTER TABLE [dbo].[BANGPHANCONG] CHECK CONSTRAINT [CHK_NgayHoanThanh_2]
GO
ALTER TABLE [dbo].[BANGPHANCONG]  WITH CHECK ADD  CONSTRAINT [CHK_NgayPhanCong_2] CHECK  (([NgayPhanCong]>=getdate()))
GO
ALTER TABLE [dbo].[BANGPHANCONG] CHECK CONSTRAINT [CHK_NgayPhanCong_2]
GO
ALTER TABLE [dbo].[BANGPHANCONG]  WITH CHECK ADD  CONSTRAINT [CHK_SoLuongCanLam_2] CHECK  (([SoLuongCanLam]>(0)))
GO
ALTER TABLE [dbo].[BANGPHANCONG] CHECK CONSTRAINT [CHK_SoLuongCanLam_2]
GO
ALTER TABLE [dbo].[BANGPHANCONG]  WITH CHECK ADD CHECK  (([MaPhanCong] like 'PC-[0-9][0-9][0-9][0-9][0-9][1-9]'))
GO
ALTER TABLE [dbo].[CHAMCONGCONGNHAN]  WITH CHECK ADD CHECK  (([MaChamCong] like 'CCCN-[0-9][0-9][0-9][0-9][0-9][1-9]'))
GO
ALTER TABLE [dbo].[CHAMCONGCONGNHAN]  WITH CHECK ADD  CONSTRAINT [CK_HeSoLuongCa_1] CHECK  (([HeSoLuongCa]>(0.0)))
GO
ALTER TABLE [dbo].[CHAMCONGCONGNHAN] CHECK CONSTRAINT [CK_HeSoLuongCa_1]
GO
ALTER TABLE [dbo].[CHAMCONGCONGNHAN]  WITH CHECK ADD  CONSTRAINT [CK_SoLuongSanPham_1] CHECK  (([SoLuongSanPham]>=(0)))
GO
ALTER TABLE [dbo].[CHAMCONGCONGNHAN] CHECK CONSTRAINT [CK_SoLuongSanPham_1]
GO
ALTER TABLE [dbo].[CHAMCONGNHANVIEN]  WITH CHECK ADD  CONSTRAINT [CHK_HeSoLuongCa_GT_0] CHECK  (([HeSoLuongCa]>(0.0)))
GO
ALTER TABLE [dbo].[CHAMCONGNHANVIEN] CHECK CONSTRAINT [CHK_HeSoLuongCa_GT_0]
GO
ALTER TABLE [dbo].[CHAMCONGNHANVIEN]  WITH CHECK ADD  CONSTRAINT [CHK_NghiPhep_0_1] CHECK  (([NghiPhep]=(1) OR [NghiPhep]=(0)))
GO
ALTER TABLE [dbo].[CHAMCONGNHANVIEN] CHECK CONSTRAINT [CHK_NghiPhep_0_1]
GO
ALTER TABLE [dbo].[CHAMCONGNHANVIEN]  WITH CHECK ADD  CONSTRAINT [CHK_TrangThai_0_1] CHECK  (([TrangThai]=(1) OR [TrangThai]=(0)))
GO
ALTER TABLE [dbo].[CHAMCONGNHANVIEN] CHECK CONSTRAINT [CHK_TrangThai_0_1]
GO
ALTER TABLE [dbo].[CHAMCONGNHANVIEN]  WITH CHECK ADD  CONSTRAINT [CK__CHAMCONGN__MaCha__534D60F1] CHECK  (([MaChamCong] like 'CCNV-[0-9][0-9][0-9][0-9][0-9][0-9]'))
GO
ALTER TABLE [dbo].[CHAMCONGNHANVIEN] CHECK CONSTRAINT [CK__CHAMCONGN__MaCha__534D60F1]
GO
ALTER TABLE [dbo].[CONGNHAN]  WITH CHECK ADD CHECK  (([MaCongNhan] like 'CN\_[0-9][0-9][0-9][0-9][1-9]' escape '\' ))
GO
ALTER TABLE [dbo].[CONGNHAN]  WITH CHECK ADD  CONSTRAINT [CK_CMND2] CHECK  ((len([CMND])=(12) OR len([CMND])=(9)))
GO
ALTER TABLE [dbo].[CONGNHAN] CHECK CONSTRAINT [CK_CMND2]
GO
ALTER TABLE [dbo].[CONGNHAN]  WITH CHECK ADD  CONSTRAINT [CK_Email2] CHECK  (([Email] like '%@%'))
GO
ALTER TABLE [dbo].[CONGNHAN] CHECK CONSTRAINT [CK_Email2]
GO
ALTER TABLE [dbo].[CONGNHAN]  WITH CHECK ADD  CONSTRAINT [CK_GioiTinh2] CHECK  (([GioiTinh]=(1) OR [GioiTinh]=(0)))
GO
ALTER TABLE [dbo].[CONGNHAN] CHECK CONSTRAINT [CK_GioiTinh2]
GO
ALTER TABLE [dbo].[NHANVIEN]  WITH CHECK ADD  CONSTRAINT [CK__NHANVIEN__MaNhan__29572725] CHECK  (([MaNhanVien] like 'NV\_[0-9][0-9][0-9][0-9]' escape '\' ))
GO
ALTER TABLE [dbo].[NHANVIEN] CHECK CONSTRAINT [CK__NHANVIEN__MaNhan__29572725]
GO
ALTER TABLE [dbo].[NHANVIEN]  WITH CHECK ADD  CONSTRAINT [CK_CMND] CHECK  ((len([CMND])=(12) OR len([CMND])=(9)))
GO
ALTER TABLE [dbo].[NHANVIEN] CHECK CONSTRAINT [CK_CMND]
GO
ALTER TABLE [dbo].[NHANVIEN]  WITH CHECK ADD  CONSTRAINT [CK_Email] CHECK  (([Email] like '%@%'))
GO
ALTER TABLE [dbo].[NHANVIEN] CHECK CONSTRAINT [CK_Email]
GO
ALTER TABLE [dbo].[NHANVIEN]  WITH CHECK ADD  CONSTRAINT [CK_GioiTinh] CHECK  (([GioiTinh]=(1) OR [GioiTinh]=(0)))
GO
ALTER TABLE [dbo].[NHANVIEN] CHECK CONSTRAINT [CK_GioiTinh]
GO
ALTER TABLE [dbo].[NHANVIEN]  WITH CHECK ADD  CONSTRAINT [CK_HeSoLuong] CHECK  (([HeSoLuong]>=(1.0)))
GO
ALTER TABLE [dbo].[NHANVIEN] CHECK CONSTRAINT [CK_HeSoLuong]
GO
ALTER TABLE [dbo].[NHANVIEN]  WITH CHECK ADD  CONSTRAINT [CK_LuongCoBan] CHECK  (([LuongCoBan]>(0)))
GO
ALTER TABLE [dbo].[NHANVIEN] CHECK CONSTRAINT [CK_LuongCoBan]
GO
ALTER TABLE [dbo].[NHANVIEN]  WITH CHECK ADD  CONSTRAINT [CK_PhuCap] CHECK  (([PhuCap]>=(0)))
GO
ALTER TABLE [dbo].[NHANVIEN] CHECK CONSTRAINT [CK_PhuCap]
GO
ALTER TABLE [dbo].[PHANDOAN]  WITH CHECK ADD CHECK  (([MaPhanDoan] like 'PD-[0-9][0-9][0-9][0-9][0-9][1-9]'))
GO
ALTER TABLE [dbo].[PHANDOAN]  WITH CHECK ADD  CONSTRAINT [CK_GiaPhanDoan_GT_0] CHECK  (([GiaPhanDoan]>(0.0)))
GO
ALTER TABLE [dbo].[PHANDOAN] CHECK CONSTRAINT [CK_GiaPhanDoan_GT_0]
GO
ALTER TABLE [dbo].[PHONGBAN]  WITH CHECK ADD CHECK  (([MaPhongBan] like 'PB\_%' escape '\' ))
GO
ALTER TABLE [dbo].[SANPHAM]  WITH CHECK ADD  CONSTRAINT [CHK_NgayHoanThanh] CHECK  (([NgayHoanThanh]>=getdate()))
GO
ALTER TABLE [dbo].[SANPHAM] CHECK CONSTRAINT [CHK_NgayHoanThanh]
GO
ALTER TABLE [dbo].[SANPHAM]  WITH CHECK ADD  CONSTRAINT [CHK_SoLuongCanLam] CHECK  (([SoLuongCanLam]>(0)))
GO
ALTER TABLE [dbo].[SANPHAM] CHECK CONSTRAINT [CHK_SoLuongCanLam]
GO
ALTER TABLE [dbo].[SANPHAM]  WITH CHECK ADD CHECK  (([MaSanPham] like 'SP\_%' escape '\' ))
GO
ALTER TABLE [dbo].[TAIKHOAN]  WITH CHECK ADD  CONSTRAINT [CK_MatKhau] CHECK  ((len([MatKhau])>=(8) AND [MatKhau] like '%[a-zA-Z]%[0-9]%' AND [MatKhau] like '%[A-Z]%'))
GO
ALTER TABLE [dbo].[TAIKHOAN] CHECK CONSTRAINT [CK_MatKhau]
GO
