package pl.transport.transportapp.model.currency;

import java.util.ArrayList;
import java.util.List;

public class Currency {

        private String table;
        private String currency;
        private String code;
        private List<Rate> rates;




        public String getTable() { return this.table; }

        public void setTable(String table) { this.table = table; }

        public String getCurrency() { return this.currency; }

        public void setCurrency(String currency) { this.currency = currency; }

        public String getCode() { return this.code; }

        public void setCode(String code) { this.code = code; }

        public List<Rate> getRates() { return this.rates; }

        public void setRates(List<Rate> rates) { this.rates = rates; }

}

