package com.fakeSocial.back.persistance;

import com.fakeSocial.back.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
}
