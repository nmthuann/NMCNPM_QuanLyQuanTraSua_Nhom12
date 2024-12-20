USE [master]
GO
/****** Object:  Database [QuanLyQuanTraSua_Nhom12]    Script Date: 5/13/2024 04:03:36 PM ******/
CREATE DATABASE [QuanLyQuanTraSua_Nhom12]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyQuanTraSua_Nhom12', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\QuanLyQuanTraSua_Nhom12.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLyQuanTraSua_Nhom12_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\QuanLyQuanTraSua_Nhom12_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyQuanTraSua_Nhom12].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET RECOVERY FULL 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'QuanLyQuanTraSua_Nhom12', N'ON'
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET QUERY_STORE = OFF
GO
USE [QuanLyQuanTraSua_Nhom12]
GO
/****** Object:  Table [dbo].[DetailBill]    Script Date: 5/13/2024 04:03:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DetailBill](
	[BillID] [int] NOT NULL,
	[DrinkID] [nvarchar](10) NOT NULL,
	[Size] [bit] NOT NULL,
	[Quantity] [smallint] NOT NULL,
 CONSTRAINT [CTHD_pk] PRIMARY KEY CLUSTERED 
(
	[BillID] ASC,
	[DrinkID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Drink]    Script Date: 5/13/2024 04:03:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Drink](
	[DrinkID] [nvarchar](10) NOT NULL,
	[DrinkName] [nvarchar](50) NOT NULL,
	[Price] [int] NOT NULL,
	[Unit] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK__Drink__C094D3C8348FFBBA] PRIMARY KEY CLUSTERED 
(
	[DrinkID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[DETAIL_Bill2]    Script Date: 5/13/2024 04:03:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create VIEW [dbo].[DETAIL_Bill2]
AS
	SELECT dr.DrinkName,dr.Price, dt.Size, dt.Quantity FROM DetailBill dt,Drink dr
	WHERE dr.DrinkID = dt.DrinkID AND dt.BillID = 2
GO
/****** Object:  View [dbo].[DETAIL_Bill2_test]    Script Date: 5/13/2024 04:03:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create VIEW [dbo].[DETAIL_Bill2_test]
AS
	SELECT dr.DrinkName,dr.Price, dt.Size, dt.Quantity, total = 
	(dr.Price * dt.Quantity + '10000' ) FROM DetailBill dt,Drink dr
	WHERE dr.DrinkID = dt.DrinkID AND dt.BillID = 2 AND dt.Size = 1
GO
/****** Object:  View [dbo].[DETAIL_Bill2_test1]    Script Date: 5/13/2024 04:03:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create VIEW [dbo].[DETAIL_Bill2_test1]
AS
	SELECT dr.DrinkName,dr.Price, dt.Size, dt.Quantity,
	CASE 
		WHEN dt.Size = 1 THEN dr.Price * dt.Quantity + '10000' 
		WHEN dt.Size = 0 THEN dr.Price * dt.Quantity + '0' 
	END AS total
	FROM DetailBill dt,Drink dr
	WHERE dr.DrinkID = dt.DrinkID AND dt.BillID = 2 
	--, total = (dr.Price * dt.Quantity + '10000' )
GO
/****** Object:  Table [dbo].[Bill]    Script Date: 5/13/2024 04:03:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bill](
	[BillID] [int] IDENTITY(1,1) NOT NULL,
	[EmployeeID] [int] NOT NULL,
	[SeatID] [int] NULL,
	[CustomerID] [nvarchar](100) NULL,
	[CreateBillDay] [date] NOT NULL,
 CONSTRAINT [PK__Bill__11F2FC4AA4777849] PRIMARY KEY CLUSTERED 
(
	[BillID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 5/13/2024 04:03:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[CustomerID] [nvarchar](100) NOT NULL,
	[CustomerName] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[CustomerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Employee]    Script Date: 5/13/2024 04:03:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employee](
	[EmployeeID] [int] IDENTITY(1,1) NOT NULL,
	[FirstName] [nvarchar](50) NULL,
	[LastName] [nvarchar](10) NOT NULL,
	[Gender] [bit] NULL,
	[Birthday] [date] NOT NULL,
	[Phone] [char](11) NULL,
	[Address] [nvarchar](100) NULL,
	[Email] [nvarchar](100) NOT NULL,
	[PositionID] [int] NOT NULL,
	[StartDay] [date] NOT NULL,
	[EmployeeStatus] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[EmployeeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [Contraint_Email] UNIQUE NONCLUSTERED 
(
	[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UK_lr4rxbomolacdwtvj7a9ophix] UNIQUE NONCLUSTERED 
(
	[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[Phone] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[EmployeeAccount]    Script Date: 5/13/2024 04:03:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EmployeeAccount](
	[UserName] [nvarchar](100) NOT NULL,
	[Password] [char](20) NOT NULL,
	[Role] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[UserName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Position]    Script Date: 5/13/2024 04:03:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Position](
	[PositionID] [int] IDENTITY(1,1) NOT NULL,
	[PositionName] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[PositionID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Seat]    Script Date: 5/13/2024 04:03:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Seat](
	[SeatID] [int] IDENTITY(1,1) NOT NULL,
	[SeatNum] [smallint] NOT NULL,
	[SeatStatus] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[SeatID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Employee] ADD  DEFAULT ((1)) FOR [EmployeeStatus]
GO
ALTER TABLE [dbo].[EmployeeAccount] ADD  DEFAULT ('12345678') FOR [Password]
GO
ALTER TABLE [dbo].[EmployeeAccount] ADD  DEFAULT ((0)) FOR [Role]
GO
ALTER TABLE [dbo].[Seat] ADD  DEFAULT ((0)) FOR [SeatStatus]
GO
ALTER TABLE [dbo].[Bill]  WITH CHECK ADD  CONSTRAINT [FK__Bill__CustomerID__36B12243] FOREIGN KEY([CustomerID])
REFERENCES [dbo].[Customer] ([CustomerID])
GO
ALTER TABLE [dbo].[Bill] CHECK CONSTRAINT [FK__Bill__CustomerID__36B12243]
GO
ALTER TABLE [dbo].[Bill]  WITH CHECK ADD  CONSTRAINT [FK__Bill__EmployeeID__34C8D9D1] FOREIGN KEY([EmployeeID])
REFERENCES [dbo].[Employee] ([EmployeeID])
GO
ALTER TABLE [dbo].[Bill] CHECK CONSTRAINT [FK__Bill__EmployeeID__34C8D9D1]
GO
ALTER TABLE [dbo].[Bill]  WITH CHECK ADD  CONSTRAINT [FK__Bill__SeatID__35BCFE0A] FOREIGN KEY([SeatID])
REFERENCES [dbo].[Seat] ([SeatID])
GO
ALTER TABLE [dbo].[Bill] CHECK CONSTRAINT [FK__Bill__SeatID__35BCFE0A]
GO
ALTER TABLE [dbo].[DetailBill]  WITH CHECK ADD  CONSTRAINT [FK__DetailBil__BillI__398D8EEE] FOREIGN KEY([BillID])
REFERENCES [dbo].[Bill] ([BillID])
GO
ALTER TABLE [dbo].[DetailBill] CHECK CONSTRAINT [FK__DetailBil__BillI__398D8EEE]
GO
ALTER TABLE [dbo].[DetailBill]  WITH CHECK ADD  CONSTRAINT [FK__DetailBil__Drink__3A81B327] FOREIGN KEY([DrinkID])
REFERENCES [dbo].[Drink] ([DrinkID])
GO
ALTER TABLE [dbo].[DetailBill] CHECK CONSTRAINT [FK__DetailBil__Drink__3A81B327]
GO
ALTER TABLE [dbo].[Employee]  WITH CHECK ADD FOREIGN KEY([Email])
REFERENCES [dbo].[EmployeeAccount] ([UserName])
GO
ALTER TABLE [dbo].[Employee]  WITH CHECK ADD FOREIGN KEY([PositionID])
REFERENCES [dbo].[Position] ([PositionID])
GO
ALTER TABLE [dbo].[Customer]  WITH CHECK ADD  CONSTRAINT [Constraint_CustomerID] CHECK  ((len([CustomerID])>=(10)))
GO
ALTER TABLE [dbo].[Customer] CHECK CONSTRAINT [Constraint_CustomerID]
GO
ALTER TABLE [dbo].[Employee]  WITH CHECK ADD  CONSTRAINT [Constraint_Birthday] CHECK  (((datepart(year,[StartDay])-datepart(year,[Birthday]))>(18)))
GO
ALTER TABLE [dbo].[Employee] CHECK CONSTRAINT [Constraint_Birthday]
GO
ALTER TABLE [dbo].[Employee]  WITH CHECK ADD  CONSTRAINT [Constraint_Phone] CHECK  ((len([Phone])>=(10)))
GO
ALTER TABLE [dbo].[Employee] CHECK CONSTRAINT [Constraint_Phone]
GO
ALTER TABLE [dbo].[EmployeeAccount]  WITH CHECK ADD  CONSTRAINT [Constraint_Password] CHECK  ((len([Password])>=(8)))
GO
ALTER TABLE [dbo].[EmployeeAccount] CHECK CONSTRAINT [Constraint_Password]
GO
USE [master]
GO
ALTER DATABASE [QuanLyQuanTraSua_Nhom12] SET  READ_WRITE 
GO
