create table kullanicilar(
  id Serial PRIMARY KEY,
  kuladi varchar(50) not NULL,
  sifre varchar(32)  not NULL,
  adi varchar(255),
  soyadi varchar(255),
  mail varchar(255),
  tarih TIMESTAMP default CURRENT_TIMESTAMP,
  
);

CREATE TABLE siparisler (
  id Serial PRIMARY KEY,
  kullanicilar_id int,
  fiyat int not NULL,
  siparisdurumu Varchar(5) not null,
  

  constraint kullanicilar_fk foreign key(kullanicilar_id) references kullanicilar(id)
);

CREATE TABLE kategoriler (
  id Serial PRIMARY KEY,
  kategoriadi varchar(255) not NULL,
 
);


CREATE TABLE urunler (
  id Serial PRIMARY KEY,
  kategoriler_id int,
  baslik varchar(255)  not NULL,
  urundetayi varchar(255)  not NULL,
  kampanyali_fiyati int not NULL,
  Normal_fiyati int not NULL,
  stok int not NULL,
 
  constraint kategoriler_fk foreign key (kategoriler_id) references kategoriler(id)
);


CREATE TABLE sepet (
  id Serial PRIMARY KEY,
  adet int not NULL,
  sepetfiyati int not NULL,
  sepetdurum varchar(30) not NULL 
  
);

create table urun_sepet_ekle(
	id Serial PRIMARY KEY,
	urunler_id int,
	sepet_id int,
	
	constraint urunler_fk foreign key (urunler_id) references urunler(id),
	constraint sepet_fk foreign key (sepet_id) references sepet (id)
);

CREATE TABLE urun_resimleri (
  id Serial PRIMARY KEY,
  urunler_id int,
  urunAdi varchar(500)  not NULL,
  klasor varchar(500)  not NULL,

  constraint urunler_fk foreign key(urunler_id) references urunler(id)
);



CREATE TABLE begeniler (
   id Serial PRIMARY KEY,
   kullanicilar_id int,
   urunler_id int,
   puan int ,
   
 
  constraint urunler_fk foreign key (urunler_id) references urunler(id),
  constraint kullanicilar_fk foreign key (kullanicilar_id) references kullanicilar(id)
);