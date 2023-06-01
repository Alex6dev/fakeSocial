package com.fakeSocial.back.persistance;

import com.fakeSocial.back.model.Profil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilRepository extends JpaRepository<Profil,Long> {
}
