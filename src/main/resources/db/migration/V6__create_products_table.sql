create table products
(
    productsId    int auto_increment
        primary key,
    productsName  varchar(255) null,
    productsPrice decimal      null,
    categoriesId  int          null,
    constraint products_categories_categoriesId_fk
        foreign key (categoriesId) references categories (categoriesId)
);
