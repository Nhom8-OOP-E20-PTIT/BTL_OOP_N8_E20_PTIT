create database Thi_THPTQG
go
use Thi_THPTQG
go
CREATE TABLE DIAPHUONG(
madp char(5) primary key check(madp like '[0-9][0-9][-][0-9][0-9]'),
tenqh nvarchar(30) not null,
tentinhthanh nvarchar(16)  not null,
)
go
CREATE TABLE THPT(
mathpt char(6) primary key check(mathpt like '[0-9][0-9][-][0-9][0-9][0-9]'), 
tentruong nvarchar(50) not null,
madp char(5) foreign key references DIAPHUONG(madp) not null,
)
go
CREATE TABLE THISINH(
scmnd char(12) primary key check(scmnd like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]%') ,
holot nvarchar(30)  check( holot like N'[a-z]%') not null,
ten nvarchar(7) check( ten like N'[a-z]%') not null,
birthday datetime not null,
gioitinh char(1) not null,
doituong char(1),
khuvuc char(3) check (khuvuc in('1','2','3','2NT'))  not null,
mathpt char(6) foreign key references THPT(mathpt),
matkhau char(10) not null,
)
go
CREATE TABLE CUMTHI(
macum char(3) primary key check(macum like '[A-Z][A-Z][A-Z]'),
tencum nvarchar(50)  not null,
madp char(5) foreign key references DIAPHUONG(madp) not null,
)
go
CREATE TABLE DKTHI(
scmnd char(12) foreign key references THISINH(scmnd),
macum char(3) foreign key references CUMTHI(macum),
madk int identity(10000,1)primary key,
tongdiem decimal(5,2) check(tongdiem>=0),
diemuutien decimal(5,2) check (diemuutien>=0 and diemuutien<=3.5),
UNIQUE(macum,scmnd)
)
go
CREATE TABLE MONTHI(
mamon char(5) primary key,
tenmon nvarchar(9) not null,
heso decimal(4,1) check(heso>=1 and heso<=3),
ngaythi datetime,
giothi time,
)
go
CREATE TABLE LICHCN(
madk int foreign key references DKTHI(madk),
mamon char(5)foreign key references MONTHI(mamon),
diem decimal(4,1) check(diem>=0 and diem<=10),
phongthi char(4),
UNIQUE(madk,mamon)
)
go
insert into DIAPHUONG values(N'04-03',N'Quận Sơn Trà',N'Đà Nẵng')
insert into THPT values('04-001',N'THPT Nguyễn Hiền','04-03')
insert CUMTHI values('DND',N'Đại Học Đà Nẵng','04-03')
insert MONTHI(mamon,tenmon,heso,ngaythi,giothi) values('TOAN',N'Toán',1,'2017-05-23','7:00:00')
insert MONTHI(mamon,tenmon,heso,ngaythi,giothi) values('VAN',N'Văn',1,'2017-05-23','9:00:00')
insert MONTHI(mamon,tenmon,heso,ngaythi,giothi) values('SINH',N'Sinh',1,'2017-05-24','7:00:00')
insert MONTHI(mamon,tenmon,heso,ngaythi,giothi) values('SU',N'Sử',1,'2017-05-24','9:00:00')
insert MONTHI(mamon,tenmon,heso,ngaythi,giothi) values('DIA',N'Địa',1,'2017-05-25','7:00:00')
insert MONTHI(mamon,tenmon,heso,ngaythi,giothi) values('HOA',N'Hóa',1,'2017-05-25','9:00:00')
insert MONTHI(mamon,tenmon,heso,ngaythi,giothi) values('LY',N'Lý',1,'2017-05-26','7:00:00')
insert MONTHI(mamon,tenmon,heso,ngaythi,giothi) values('ANH',N'Ngoại Ngữ',1,'2017-05-26','9:00:00')