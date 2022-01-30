package com.project.fundoonotes.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.fundoonotes.dto.LabelDto;
import com.project.fundoonotes.model.Label;

/**
 * @Repository : Creating Repository to store data in DataBase
 */
@Repository
public interface LabelRepository extends JpaRepository<Label, Integer> {

	Label save(LabelDto labelDto);

	List<Label> findByUserId(int userId);

}
