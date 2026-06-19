package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;


public class Portfolio {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;   // <-- field, not inside a method

        @Column(nullable = false)
        private String type;

        // Relationship: One Portfolio → One Client
        @OneToOne
        @JoinColumn(name = "client_id", referencedColumnName = "id")
        private Client client;

        protected Portfolio() {}

        public Portfolio(String type, Client client) {
            this.type = type;
            this.client = client;
        }

        // Getters and setters
        public Long getId() { return id; }
        public String getType() { return type; }
        public void setType(String type) { this.type = type; }
        public Client getClient() { return client; }
        public void setClient(Client client) { this.client = client; }
}
