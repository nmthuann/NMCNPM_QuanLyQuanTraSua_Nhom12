# Quản Lý Quán Trà Sữa

## NHẬP MÔN CÔNG NGHỆ PHẦN MỀM

## ĐỀ TÀI: QUẢN LÝ QUÁN TRÀ SỮA

**GVHD:** Nguyễn Thị Bích Nguyên  
**Nhóm:** 12

| Họ và tên           | Mã số sinh viên |
| ------------------- | --------------- |
| Nguyễn Minh Thuận   | N19DCCN202      |
| Trần Thị Diệu My    | N19DCPT036      |
| Đào Lê Phương Duyên | N19DCPT009      |

TPHCM, ngày 31 tháng 05 năm 2022

# A.PHÂN TÍCH ĐỀ TÀI

## I. Mô tả yêu cầu đề tài

### 1. Thực trạng:

- Trong những năm gần đây, nhu cầu sử dụng website không ngừng tăng nhanh và việc quản lí một công việc nào đó bằng web ngày càng tăng cao.
- Từ đó chúng em quyết định lựa chọn và thực hiện đề tài quản lý Quán Trà Sữa, nhằm tạo ra hệ thống quản lý có tính thiết thực và ứng dụng vào thực tế.

### 2. Mô tả:

- **Quy mô sử dụng**: Cho một quán trà sữa duy nhất.
- **Khảo sát thực tế**: Hiện nay có rất nhiều quán trà sữa được mở bán, cần có phần mền quản lí để tăng hiệu suất của quán. Phần mền quản lí có thể cho phép sử dụng đồ uống mang đi và dùng tại chỗ.
- **Đối tượng sử dụng**: Website của quán trà sữa là một phần mền quản lí. Quán có nhiều nhân viên và được sự quản lí bởi 1 quản lí duy nhất.
- **Nhân Viên**: Mỗi nhân viên được người quản lí đăng kí tài khoản nhân viên (Email) và với mật khẩu mặt định. Một nhân viên có các thuộc tính mã Nhân Viên, Họ, Tên, Giới tính, Ngày sinh, Email, Số điện thoại, Địa chỉ, Thời gian vào làm, Chức vụ, Trạng thái làm. Lưu ý sử dụng email để làm tên đăng nhập không được xóa nhân viên khi nghỉ làm mà đặt lại trạng thái làm là nghỉ cho nhân viên đó.
- **Tài khoản Nhân viên**: Nhân viên và Quản lí đều có 1 tài khoản để sử dụng, được cấp quyền khác nhau để phân biệt vai trò của 2 bộ phận này.
- **Chức vụ**: Chức vụ của mỗi thành viên trong quán trà sữa.
- **Thức Uống**: Là Danh Mục đồ uống của Quán có các thuộc tính: Mã Đồ Uống, Tên Đồ Uống, Đơn Giá, Đơn Vị Tính.
- **Bàn**: Quán còn có Các Bàn hay gọi là chỗ ngồi, mỗi Bàn tại 1 thời điểm sẽ có 1 Hóa đơn. Bàn có các thuộc tính: Mã Bàn, Số Ghế, Trạng Thái Bàn (Đầy – Trống).
- **Hóa Đơn**: Khi Thanh toán thì Nhân viên sẽ lập Hóa Đơn cho Khách Hàng đó. Một Hóa Đơn có Mã Hóa đơn để phân biệt, Mã Nhân Viên, Mã Chỗ Ngồi (có thể mang giá trị null nếu khách không ngồi ở quán), Mã Khách hàng (cho phép Null vì có Khách Hàng chưa đăng kí), Ngày lập hóa đơn.
- **Chi Tiết Hóa Đơn**: Và Mỗi Hóa Đơn sẽ có chi tiết Hóa Đơn, các thành phần thuộc tính của CTHD là: Số Hóa Đơn (Mã Hóa đơn), Mã Đồ Uống, Size (M - L), Số Lượng.
- **Thành Tiền**: Thành Tiền được dùng để Tính Doanh Thu của Quán, sau khi lấy tổng tiền – ưu đãi = Thành Tiền.
- **Khách Hàng**: Khi người mua đồ uống nếu muốn đăng kí làm Khách Hàng của quán để nhận những ưu đãi thì Nhân Viên Hay Quản lí (admin) sẽ đăng kí khách hàng bằng cách tạo với các thông tin như sau: Mã Khách Hàng, Tên Khách Hàng.
- **Phân loại KH**: Khách hàng được phân loại ưu đãi bằng Loại Khách hàng. Loại KH (Đồng – Bạc – Vàng – Kim Cương), dựa vào Thành Tiền của mỗi Hóa đơn đổi thành điểm tích lũy.
- **Lưu ý**: Để Quản lí một cách trực quan hơn, ta nên thiết kế bảng thống kê Hóa đơn theo ngày – tháng – năm, thông kê doanh thu bán ra theo quý – năm, để thể tạo biểu độ để nhìn tổng quát hơn. Website có 2 chế độ giao diện sử dụng đăng nhập và không đăng nhập. Về đăng nhập sẽ có 2 chế độ user – admin (Nhân viên – Quản lí).

## II. Phân tích yêu cầu đề tài

### 1. Yêu cầu đề tài

- **Đối tượng sử dụng**: Nhân viên và Quản Lý Quán.

  - **Nhân Viên**: Có quyền hạn thấp hơn quản lý, nên chỉ sử dụng được một số chức năng nhất định.
  - **Quản lý**: Là người có quyền hạn cao nhất (trừ 1 số chức năng), quản lý toàn bộ mọi hoạt động của website. Có thể xem, sửa thông tin hoặc tắt hoạt động khách hàng nếu vi phạm điều khoản cửa hàng, mới hay hợp tác với nhà cung cấp mới. Xem chi tiết và thống kê hóa đơn.

- **Một Số chức năng của Web**:

  - Chức năng về tài khoản
  - Chức năng quản lí (…)
  - Chức năng gọi thức uống
  - Một số chức năng khác.

- **Quyền hạn sử dụng chức năng (xem, thêm, xóa, sửa, tìm kiếm)**:
  - **Nhân Viên**:
    - Khách Hàng (toàn quyền trừ xóa)
    - Order
    - Thức uống: chỉ xem
    - Bàn (chỗ ngồi): thay đổi trạng thái bàn
    - Thay đổi thông tin cá nhân của nhân viên đó.
  - **Quản lí**:
    - Tài khoản:
      - Xem, thêm, sửa thông tin (xóa khi 1 nhân viên nghỉ làm, cập nhật trạng thái).
      - Tạo Tài khoản cho nhân viên (đăng kí).
      - Reset mật khẩu nhân viên.
    - Nhân Viên (toàn quyền, nhưng không được xóa).
    - Chức vụ (toàn quyền)
    - Thức Uống (toàn quyền)
    - Khách hàng (Toàn quyền trừ xóa)
    - Chỗ ngồi (thay đổi trạng thái bàn)
    - Order (gọi món)
    - Thống kê:
      - Xem doanh doanh thu tuần, doanh thu tháng này, doanh thu năm.
      - Xem thống kê chi tiết hóa đơn.
      - Phân loại khách hàng.

## Cơ sỡ dữ liệu

### Thiết kế CSDL

- ![alt text](/docs/images/image.png)

### Các Table trong CSDL

# Bảng POSITION (Chức Vụ):

| FIELD        | Kiểu          | Ràng buộc | Ý nghĩa     |
| ------------ | ------------- | --------- | ----------- |
| PositionID   | Int, tăng dần | PK        | Mã Chức vụ  |
| PositionName | Nvarchar (50) | Not null  | Tên Chức vụ |

# Bảng EMPLOYEEACCOUNT (Tài khoản Nhân Viên):

| FIELD    | Kiểu           | Ràng buộc                    | Ý nghĩa       |
| -------- | -------------- | ---------------------------- | ------------- |
| UserName | Nvarchar (100) | PK                           | Tên tài khoản |
| Password | Char (20)      | Not null, Tối thiểu 8 kí tự. | Mật khẩu      |
| Role     | Bit            | Not null, DEFAULT0           | Quyền         |

# Bảng EMPLOYEE (Nhân Viên):

| FIELD          | Kiểu           | Ràng buộc               | Ý nghĩa                                 |
| -------------- | -------------- | ----------------------- | --------------------------------------- |
| EmployeeID     | Int, tự tăng   | PK                      | Mã nhân viên                            |
| FirstName      | Nvarchar (50)  | NULL                    | Họ                                      |
| LastName       | Nvarchar (10)  | Not null                | Tên                                     |
| Gender         | Bit            | Null                    | Giới tính                               |
| Birthday       | Date           | Not null                | Sinh nhật                               |
| Phone          | Char 11        | Null                    | Số điện thoại                           |
| Address        | Nvarchar (100) | Null                    | Địa chỉ                                 |
| Email          | Nvarchar (100) | FK (empAcc), not null   | Email                                   |
| PositionID     | Int            | FK (Position), Not null | Mã chức vụ                              |
| StartDay       | Date           | Not null                | Ngày vào làm                            |
| EmployeeStatus | Bit            | Not Null, DEFAULT 1     | Trạng thái nhân viên nghỉ làm hoặc chưa |

# Bảng CUSTOMER (Khách Hàng):

| FIELD        | Kiểu           | Ràng buộc | Ý nghĩa        |
| ------------ | -------------- | --------- | -------------- |
| CustomerID   | Nvarchar (100) | PK        | Mã Khách Hàng  |
| CustomerName | Nvarchar (50)  | Not null  | Tên khách Hàng |

# Bảng DRINK (Thức Uống):

| FIELD     | Kiểu          | Ràng buộc | Ý nghĩa       |
| --------- | ------------- | --------- | ------------- |
| DrinkID   | Nvarchar (10) | PK        | Mã thức uống  |
| DrinkName | Nvarchar (50) | Not null  | Tên thức uống |
| Price     | Smallmoney    | Not null  | Giá           |
| Unit      | Nvarchar (10) | Not null  | Đơn vị        |

# Bảng SEAT (Chỗ Ngồi):

| FIELD      | Kiểu           | Ràng buộc | Ý nghĩa        |
| ---------- | -------------- | --------- | -------------- |
| SeatID     | Int (identity) | PK        | Mã Chỗ ngồi    |
| SeatNum    | SmallInt       | Not null  | Số ghế         |
| SeatStatus | Bit            | Not null  | Trạng thái bàn |

# Bảng BILL (Hóa Đơn):

| FIELD         | Kiểu           | Ràng buộc          | Ý nghĩa          |
| ------------- | -------------- | ------------------ | ---------------- |
| BillID        | Int, identity  | PK                 | Mã hóa đơn       |
| EmployeeID    | Int            | FK (empl) not null | Mã nhân viên     |
| SeatID        | Int            | FK (Seat), null    | Mã bàn           |
| CustomerID    | Nvarchar (100) | FK (Cus), null     | Mã Khách hàng    |
| CreateBillDay | Date           | Not null           | Ngày lập hóa đơn |

# Bảng DETAILBILL (Chi tiết hóa đơn):

| FIELD    | Kiểu    | Ràng buộc | Ý nghĩa          |
| -------- | ------- | --------- | ---------------- |
| BillID   | Int     | PK        | Mã hóa đơn       |
| DrinkID  | Int     | PK        | Mã thức uống     |
| Size     | Bit     | Not null  | Size (1: L, 0:M) |
| Quantity | TinyInt | Not null  | Số lượng         |

### Các Ràng buộc trong CSDL

-- Ràng buộc cho bảng EmployeeAccount --

```sql
    go
    ALTER TABLE EmployeeAccount
        -- mật khẩu phải đủ 8 kí tự và mặc định là 12345678
        ADD CONSTRAINT Constraint_Password
            Check (LEN(Password)>= 8),
            DEFAULT ('12345678') FOR Password;


    -- Ràng buộc cho bảng Nhân Viên --
    go
    ALTER TABLE Employee
        -- Lớn Hơn 18t mới cho đi làm --
        ADD CONSTRAINT Constraint_Birthday
            CHECK (YEAR(StartDay)- YEAR(Birthday)>18);

    go
    ALTER TABLE Employee
        -- Số điện thoại tối thiểu 10 số --
        ADD CONSTRAINT Constraint_Phone
            CHECK (Len(Phone)>=10),
            UNIQUE (Phone);

    go
    ALTER TABLE Employee
    -- Tên tài Khoản là Email không trùng --
    ADD CONSTRAINT Contraint_Email
        UNIQUE (Email)


    -- ràng buộc cho bảng Khách Hàng
    go
    ALTER TABLE Customer
        -- Mã KH tối thiểu 10 kí tự --
        ADD CONSTRAINT Constraint_CustomerID
            CHECK (Len(CustomerID)>=10)
```

# B. Ảnh minh họa

## Giao Diện Admin

- Trang Admin
  ![alt text](/docs/images/image-1.png)
- Trang Login
  ![alt text](/docs/images/image-2.png)
- Trang thông tin tài khoản (admin)
  ![alt text](/docs/images/image-3.png)
- Quản lý Khách Hàng
  ![alt text](/docs/images/image-4.png)
- Quản lý Thức uống
  ![alt text](/docs/images/image-5.png)
- Quản lý bàn (chỗ ngồi)
  ![alt text](/docs/images/image-6.png)
- Quản lý Nhân viên
  ![alt text](/docs/images/image-7.png)
- Quản lý bảng chức vụ
  ![alt text](/docs/images/image-8.png)
- Quản lý thông tin Nhân Viên
  ![alt text](/docs/images/image-9.png)
- Thống kê Chi tiết hóa đơn
  ![alt text](/docs/images/image-10.png)

## Giao Diện nhân viên

- Trang chủ Nhân viên
  ![alt text](/docs/images/image-11.png)
- Xem danh sách thức uống
  ![alt text](/docs/images/image-12.png)
- Xem Danh Sách Khách hàng
- Xem Chi tiết hóa đơn
- Gọi món
- Những trang thuộc quyền admin thì nhân viên không được vào và điều hướng sang trang khác
  ![alt text](/docs/images/image-13.png)

## Giao Diện khác

- Đăng Nhập
- Thay Đổi mật khẩu
- Cập Nhật Tài Khoản
- Quên mật khẩu

## Một số kĩ thuật xử lí (Back End)

a.Có tích hợp Bootstrap + jquery để thiết kế web
b.Sử dụng Hibernate để kết nối database
c.Sử dụng thư viện JSTL + EL
d.Sử dụng kĩ thuật Interceptor để phân quyền
e.Sử dụng Validation để kiểm tra lỗi nhập liệu
f.Hashpass để tăng tính bảo mật.
