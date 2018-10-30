package pl.transport.transportapp.serviceNew;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.transport.transportapp.model.currency.Currency;
@Service
public class CurrencyService {

    public Currency getEuro(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/A/EUR?format=json",Currency.class);
    }
}
