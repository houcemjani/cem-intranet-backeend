package com.ads.Investigationintranet.domain.trial;

public enum EscaladeExtension {
    //TODO Youssef mught need to verify this if it supports i18n
    ESCALADE {
        @Override
        public String getInCamelCase() {
            return "Escalade";
        }

        @Override
        public int getIdentifier() {
            return 1;
        }
    }, EXTENSION {
        @Override
        public String getInCamelCase() {
            return "Extension";
        }

        @Override
        public int getIdentifier() {
            return 2;
        }
    }, OPEN {
        @Override
        public String getInCamelCase() {
            return "Ouvert";
        }

        @Override
        public int getIdentifier() {
            return 3;
        }
    }, DOUBLE_BLINDED {
        @Override
        public String getInCamelCase() {
            return "Double aveugle";
        }

        @Override
        public int getIdentifier() {
            return 4;
        }
    }, ESCALATION {
        @Override
        public String getInCamelCase() {
            return "Escalation";
        }

        @Override
        public int getIdentifier() {
            return 5;
        }
    }, NA {
        @Override
        public String getInCamelCase() {
            return "NA";
        }

        @Override
        public int getIdentifier() {
            return 6;
        }
    };

    public abstract String getInCamelCase();

    public abstract int getIdentifier();
}
