package com.ads.Investigationintranet.domain;

public enum YesNoEnum {
    YES {
        @Override
        public String toString() {
            return "Oui";
        }
    }, NO {
        @Override
        public String toString() {
            return "Non";
        }
    }, NO_ANSWER {
        @Override
        public String toString() {
            return "Pas de reponse";
        }
    };
    public abstract String toString();
    }
