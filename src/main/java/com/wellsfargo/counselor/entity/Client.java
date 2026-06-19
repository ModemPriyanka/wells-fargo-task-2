package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;


public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // <-- field, not inside a method

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    // Relationship: Many Clients → One Advisor
    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private Advisor advisor;

    // Relationship: One Client → One Portfolio
    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private Portfolio portfolio;

    // Default constructor required by JPA
    protected Client() {}

    public Client(String name, String email, Advisor advisor) {
        this.name = name;
        this.email = email;
        this.advisor = advisor;
    }

    // Getters and setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Advisor getAdvisor() { return advisor; }
    public void setAdvisor(Advisor advisor) { this.advisor = advisor; }
    public Portfolio getPortfolio() { return portfolio; }
    public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }
}
