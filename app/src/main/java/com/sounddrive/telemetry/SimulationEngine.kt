package com.sounddrive.telemetry

class SimulationEngine {

    fun generate(
        mode: SimulationMode
    ): DrivingState {

        return when (mode) {

            SimulationMode.CITY ->
                DrivingState(
                    speedKmh = 25f,
                    acceleration = 1f,
                    corneringForce = 1f
                )

            SimulationMode.HIGHWAY ->
                DrivingState(
                    speedKmh = 90f,
                    acceleration = 3f,
                    corneringForce = 1f
                )

            SimulationMode.SPORT ->
                DrivingState(
                    speedKmh = 140f,
                    acceleration = 6f,
                    corneringForce = 4f
                )

            SimulationMode.RACE ->
                DrivingState(
                    speedKmh = 220f,
                    acceleration = 10f,
                    corneringForce = 8f
                )
        }
    }
}
