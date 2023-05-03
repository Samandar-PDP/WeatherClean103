package com.sdk.weatherclean.data.mapper

import com.sdk.weatherclean.data.model.CurrentWeatherDTO
import com.sdk.weatherclean.domain.model.CurrentWeather

fun CurrentWeatherDTO.toCurrentWeather(): CurrentWeather {
    return CurrentWeather(
        long = coord.lon,
        lat = coord.lat,
        title = weather[0].main,
        description = weather[0].description,
        icon = weather[0].icon,
        temp = main.temp,
        pressure = main.pressure,
        humidity = main.humidity,
        name = name,
        timeZone = timezone,
        wind = wind.speed,
        id = id,
        country = sys.country
    )
}