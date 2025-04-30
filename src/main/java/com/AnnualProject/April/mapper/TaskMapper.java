package com.AnnualProject.April.mapper;
import com.AnnualProject.April.dto.TaskDTO;
import com.AnnualProject.April.model.Task;
import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskDTO toDto(Task task); // No longer maps createdById

    Task toEntity(TaskDTO taskDTO); // No longer maps createdBy.id
}