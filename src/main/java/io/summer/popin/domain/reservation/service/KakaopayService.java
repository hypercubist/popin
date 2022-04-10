package io.summer.popin.domain.reservation.service;

import io.summer.popin.domain.place.dto.ReservationRequestDTO;
import io.summer.popin.domain.reservation.dto.KakaopayApproveResponseDTO;
import io.summer.popin.domain.reservation.dto.KakaopayReadyResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class KakaopayService implements PaymentService{

    @Value("${kakaopay.host}")
    private String host;

    @Value("${kakaopay.ready-url}")
    private String ready_url;

    @Value("${kakaopay.approve-url}")
    private String approve_url;

    @Value("${kakaopay.admin-key}")
    private String admin_key;

    @Value("${kakaopay.cid}")
    private String cid;

    @Value("${kakaopay.item-name}")
    private String item_name;

    @Value("${kakaopay.quantity}")
    private String quantity;

    @Value("${kakaopay.tax-free-amount}")
    private String tax_free_amount;

    @Value("${kakaopay.approval-url}")
    private String approval_url;

    @Value("${kakaopay.cancel-url}")
    private String cancel_url;

    @Value("${kakaopay.fail-url}")
    private String fail_url;

    @Override
    public KakaopayReadyResponseDTO readyPayment(ReservationRequestDTO reservationRequestDTO) {

        String partner_order_id = this.createOrderId();

        HttpHeaders headers = getHttpHeaders();

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("cid", cid);
        params.add("partner_order_id", partner_order_id);
        params.add("partner_user_id", String.valueOf(reservationRequestDTO.getGuestNo()));
        params.add("item_name", item_name);
        params.add("quantity", quantity);
        params.add("total_amount", String.valueOf(reservationRequestDTO.getTotalPrice()));
        params.add("tax_free_amount", tax_free_amount);
        params.add("approval_url", approval_url);
        params.add("cancel_url", cancel_url);
        params.add("fail_url", fail_url);

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        KakaopayReadyResponseDTO readyDTO = restTemplate.postForObject(host+ready_url, httpEntity, KakaopayReadyResponseDTO.class);

        readyDTO.setPartner_order_id(partner_order_id);
        return readyDTO;

    }

    @Override
    public KakaopayApproveResponseDTO approvePayment(ReservationRequestDTO reservationRequestDTO, KakaopayReadyResponseDTO readyDTO, String pgToken) {

        HttpHeaders headers = getHttpHeaders();

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("cid", cid);
        params.add("tid", readyDTO.getTid());
        params.add("partner_order_id", readyDTO.getPartner_order_id());
        params.add("partner_user_id", String.valueOf(reservationRequestDTO.getGuestNo()));
        params.add("pg_token", pgToken);

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        KakaopayApproveResponseDTO approveDTO = restTemplate.postForObject(host+approve_url, httpEntity, KakaopayApproveResponseDTO.class);

        return approveDTO;
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + admin_key);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE+";charset=utf-8");
        return headers;
    }
}
