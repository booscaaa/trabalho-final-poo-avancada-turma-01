package br.com.cesurgmarau.trabalho_final.core.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReviewReport {
    public static class TotalReviewsByClassification {
        public TotalReviewsByClassification(String classification, long total) {
            this.classification = classification;
            this.total = total;
        }

        public String classification;
        public long total;
    }

    public static class ClassificationsByProduct {
        public ClassificationsByProduct(String product, long muitoBom, long bom, long medio, long ruim, long muitoRuim, long total) {
            this.product = product;
            this.muitoBom = muitoBom;
            this.bom = bom;
            this.medio = medio;
            this.ruim = ruim;
            this.muitoRuim = muitoRuim;
            this.total = total;
        }

        public String product;
        @JsonProperty("muito_bom")
        public long muitoBom;
        public long bom;
        public long medio;
        public long ruim;
        @JsonProperty("muito_ruim")
        public long muitoRuim;
        public long total;
    }

    public static class TotalReviewByAccount {
        public TotalReviewByAccount(String account, long total) {
            this.account = account;
            this.total = total;
        }

        public String account;
        public long total;
    }


}
