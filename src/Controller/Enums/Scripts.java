package Controller.Enums;

public enum Scripts {
    
//    INSERT_USER_IN_MYSQL ("GRANT ALL ON *.* TO servers IDENTIFIED BY '123456' WITH GRANT OPTION;"),
    TBL_USER ("CREATE TABLE IF NOT EXISTS tbl_user "
            + "(id bigint(20) NOT NULL AUTO_INCREMENT, "
            + "user_name varchar(120) NOT NULL, "
            + "password varchar(60) NOT NULL, "
            + "login varchar(70) NOT NULL, "
            + "PRIMARY KEY(id)) "
            + "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;"),
    TBL_CLIENT ("CREATE TABLE IF NOT EXISTS tbl_client "
            + "(id bigint(20) NOT NULL AUTO_INCREMENT, "
            + "client_name varchar(120) NOT NULL, "
            + "telephone varchar(60) NOT NULL, "
            + "email varchar(100) NOT NULL, "
            + "address varchar(255) NOT NULL, "
            + "active int(1) NOT NULL, PRIMARY KEY(id) ) "
            + "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;"), 
    TBL_PROVIDER ("CREATE TABLE IF NOT EXISTS tbl_provider "
            + "(id bigint(20) NOT NULL AUTO_INCREMENT, "
            + "name varchar(255) NOT NULL, "
            + "address varchar(255) NOT NULL, "
            + "number_telephone varchar(50) NOT NULL, "
            + "email varchar(150) NOT NULL, PRIMARY KEY(id) ) "
            + "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;"),
    TBL_SERVICE ("CREATE TABLE IF NOT EXISTS tbl_service "
            + "(id bigint(20) NOT NULL AUTO_INCREMENT, "
            + "description varchar(255) NOT NULL, "
            + "sigla varchar(255) NOT NULL, PRIMARY KEY(id)) " 
            + "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;"),
    TBL_CONFIG ("CREATE TABLE IF NOT EXISTS tbl_config "
            + "(id bigint(20) NOT NULL AUTO_INCREMENT, "
            + "id_service bigint(20) NOT NULL, "
            + "date varchar(20) NOT NULL, "
            + "id_user bigint(20) NOT NULL, "
            + "active int(1) NOT NULL, "
            + "PRIMARY KEY(id) ) "
            + "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;"),
    TBL_USER_ONLINE ("CREATE TABLE IF NOT EXISTS tbl_user_online "
            + "(id bigint(20) NOT NULL AUTO_INCREMENT, "
            + "user_id bigint(20) NOT NULL, "
            + "dt_end varchar(50) NULL, PRIMARY KEY(id)) "
            + "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;"),
    TBL_DEPARTMENT ("CREATE TABLE IF NOT EXISTS tbl_department "
            + "(id bigint(20) NOT NULL AUTO_INCREMENT, "
            + "name varchar(255) NOT NULL, "
            + "PRIMARY KEY(id) ) "
            + "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;"), 
    TBL_SETING ("CREATE TABLE IF NOT EXISTS tbl_setting_of_system "
            + "(id bigint(20) NOT NULL AUTO_INCREMENT, "
            + "name_company varchar(255) NOT NULL, " 
            + "cnpj varchar(255) NOT NULL, "
            + "address varchar(255) NOT NULL, "
            + "foto varchar(255) NOT NULL, "
            + "sigla varchar(50) NOT NULL, "
            + "PRIMARY KEY(id) ) "
            + "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;"), 
    TBL_PAYMENT ("CREATE TABLE IF NOT EXISTS tbl_payments "
            + "(id bigint(20) NOT NULL AUTO_INCREMENT, "
            + "description varchar(200) NOT NULL, "
            + "initials varchar(10) NOT NULL, "
            + "code int(10) NOT NULL, "
            + "PRIMARY KEY(id) ) "
            + "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;"),
    TBL_PRODUCT_FOR_SALE ("CREATE TABLE IF NOT EXISTS tbl_product_for_sale "
            + "(product_id bigint(20) NOT NULL AUTO_INCREMENT, "
            + "product_name varchar(90) DEFAULT NULL, "
            + "stock int(11) DEFAULT NULL, "
            + "product_value_sale double DEFAULT NULL, "
            + "stock_id bigint(20) NOT NULL, "
            + "user_id int(11) NOT NULL, "
            + "dateAndhours varchar(150) NOT NULL, "
            + "code_verification varchar(200) NOT NULL, "
            + "image varchar(255) NOT NULL, "
            + "PRIMARY KEY(product_id) ) "  
            + "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;"), 
    TBL_PRODUCT_FOR_STOCK ("CREATE TABLE IF NOT EXISTS tbl_product_for_stock "
            + "(id bigint(20) NOT NULL AUTO_INCREMENT, "
            + "name varchar(255) NOT NULL, "
            + "stock int(11) NOT NULL, "
            + "value_invest double NOT NULL, " 
            + "provider_id bigint(20) NOT NULL, "
            + "department_id bigint(20) NOT NULL, "
            + "user_id bigint(20) NOT NULL, "
            + "code_verification varchar(200) NOT NULL, "
            + "value_single double NOT NULL, "
            + "PRIMARY KEY(id), FOREIGN KEY (user_id) REFERENCES tbl_user (id), FOREIGN KEY (department_id) REFERENCES tbl_department (id), FOREIGN KEY (provider_id) REFERENCES tbl_provider (id)) "
            + "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;"),
    TBL_SALES ("CREATE TABLE IF NOT EXISTS tbl_sales "
            + "(id bigint(20) NOT NULL AUTO_INCREMENT, "
            + "sale_id bigint(20) NOT NULL , "
            + "type_sales_id bigint(20) NOT NULL, "
            + "user_id bigint(11) NOT NULL, "
            + "client_id bigint(11) NOT NULL, " 
            + "sale_date varchar(100) NOT NULL, "
            + "the_amount int(11) NOT NULL, "
            + "net_value double NOT NULL, "
            + "gross_value double NOT NULL, "
            + "discount double NOT NULL, "
            + "total_value double NOT NULL, "
            + "status varchar(60) NULL, "
            + "shift_id int NOT NULL, "
            + "user_id_alter_status int NULL, " 
            + "date_status varchar(30) NULL, "
            + "PRIMARY KEY(id), FOREIGN KEY (client_id) REFERENCES tbl_client (id), FOREIGN KEY (user_id) REFERENCES tbl_user (id))"
            + "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;"), 
    TBL_SALE_PAYMENT ("CREATE TABLE IF NOT EXISTS tbl_sale_payment "
            + "(id bigint(20) NOT NULL AUTO_INCREMENT, "
            + "payment_id bigint(20) NOT NULL, "
            + "sale_id bigint(20) NOT NULL, "
            + "PRIMARY KEY(id)) "
            + "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;"),
    TBL_SALE_PRODUCT ("CREATE TABLE IF NOT EXISTS tbl_sale_product "
            + "(id bigint(20) NOT NULL AUTO_INCREMENT, "
            + "name varchar(150) NOT NULL, "
            + "sale_id bigint(20) NOT NULL,"
            + "user_id bigint(20) NOT NULL, " 
            + "value_sale double NOT NULL, "
            + "hours varchar(12) NOT NULL, "
            + "amount int(11) NOT NULL, "
            + "client_id bigint(20) NOT NULL, "
            + "product_id bigint(20) NOT NULL, "
            + "PRIMARY KEY(id), FOREIGN KEY (user_id) REFERENCES tbl_user (id), FOREIGN KEY (client_id) REFERENCES tbl_client (id), FOREIGN KEY (product_id) REFERENCES tbl_product_for_sale (product_id))"
            + "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;"), 
    TBL_SHIFT ("CREATE TABLE IF NOT EXISTS tbl_shift_closed "
            + "(id bigint(20) NOT NULL AUTO_INCREMENT, "
            + "shift_id bigint(20) NOT NULL, "
            + "user_id bigint(20) NOT NULL, "
            + "dt_start varchar(200) NOT NULL, "
            + "dt_end varchar(200) , "
            + "value_start double NOT NULL, "
            + "value_all_sales double, "
            + "PRIMARY KEY(id)) "
            + "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;"),
    TBL_DETAILS_SHIFT ("CREATE TABLE IF NOT EXISTS tbl_details_shift "
            + "(id bigint(20) NOT NULL AUTO_INCREMENT, "
            + "shift_id bigint(20) NOT NULL, "
            + "value_start double NOT NULL, "
            + "valor_total_no_dinheiro_cartao_ticket double NOT NULL, "
            + "valor_total_no_dinheiro_cartao_ticket_a_prazo double , "
            + "quantidade_de_vendas_no_dinheiro_cartao_ticket_a_prazo int(11) NOT NULL, "
            + "quantidade_de_vendas_no_dinheiro_cartao_ticket int(11) NOT NULL, "
            + "valor_total_no_dinheiro double NOT NULL, "
            + "vl_total_dinheiro_mais_valor_inicial_c_desc_da_sangria double NOT NULL, "
            + "quantidade_de_vendas_do_dinheiro int(11) NOT NULL, "
            + "valor_total_no_cartao double NOT NULL, "
            + "quantidade_de_vendas_no_cartao int(11) NOT NULL, "
            + "valor_total_no_ticket double NOT NULL, "
            + "quantidade_de_vendas_no_ticket int(11) NOT NULL, "
            + "valor_total_em_a_prazo double NOT NULL, "
            + "quantidade_de_vendas_a_prazo int(11) NOT NULL, "
            + "valor_total_de_vendas_abandonadas double NOT NULL, "
            + "quantidade_de_vendas_abandonadas int(11) NOT NULL, "
            + "valor_total_de_vendas_canceladas double NOT NULL, "
            + "quantidade_de_vendas_canceladas int(11) NOT NULL, "
            + "value_withdrawals double NOT NULL, "
            + "PRIMARY KEY(id)) "
            + "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;");
    
    
    private String descricao;

    private Scripts(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }

}




