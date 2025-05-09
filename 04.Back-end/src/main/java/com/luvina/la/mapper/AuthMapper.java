package com.luvina.la.mapper;

import com.luvina.la.dto.AuthDTO;
import com.luvina.la.entity.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * use:
 *  EmployeeMapper.MAPPER.toEntity(dto);
 *  EmployeeMapper.MAPPER.toList(list);
 */
@Mapper
public interface AuthMapper {
    AuthMapper MAPPER = Mappers.getMapper( AuthMapper.class );

    Auth toEntity(AuthDTO entity);
    Auth toDto(AuthDTO entity);
    Iterable<AuthDTO> toList(Iterable<Auth> list);

}
