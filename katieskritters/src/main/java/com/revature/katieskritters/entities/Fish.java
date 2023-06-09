package com.revature.katieskritters.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "fish")
public class Fish {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fish_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    // @ManyToOne
    // @JoinColumn(name = "favorite_id")
    // @JsonBackReference
    // private Favorite favorite;

    @OneToMany(mappedBy = "fish", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<CartItem> cartItem;

}
