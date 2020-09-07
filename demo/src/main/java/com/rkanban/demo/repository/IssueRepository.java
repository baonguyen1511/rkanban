package com.rkanban.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rkanban.demo.models.Issue;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Integer> {

}
