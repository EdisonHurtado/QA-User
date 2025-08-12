package com.user.qauser.Repository;

import com.user.qauser.Domain.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface HobbyRepository extends JpaRepository<Hobby, UUID> {}
