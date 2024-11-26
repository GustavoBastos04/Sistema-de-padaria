import React from "react"
import { Card } from "react-bootstrap";
import { useEffect, useState } from "react";
import { PieChart } from '@mui/x-charts/PieChart'
import { BarChart } from '@mui/x-charts/BarChart'
import { api } from '../../services/api'

function HistoricoPagamentos() {

    const [pieData, setPieData] = useState([])
    const [barData, setBarData] = useState({xAxis: [], series: []})

    async function loadPayments() {
        try {
            const response = await api.get('meio-pagamento')
            if (Array.isArray(response.data)) {
                const pieData = response.data.map((item, index) => ({
                    id: index,
                    value: item.qtd_vendas,
                    label: item.tipo,
                }))
                const barData = {
                    xAxis: response.data.map((item) => item.tipo),
                    series: response.data.map((item) => item.valor_total),
                }
                return {pieData, barData}
            }
            return {pieData: [], barData: {xAxis: [], series: []}}
        } catch (error) {
            console.error("Erro ao carregar dados: ", error)
            return {pieData: [], barData: {xAxis: [], series: []}}
        }
    }

    useEffect(() => {
        loadPayments().then(({pieData, barData}) => {
            setPieData(pieData)
            setBarData(barData)
        })
    }, [])

    return (
        <div className="d-flex gap-4 justify-content-center align-items-center vh-100">
            <Card className="shadow mb-4">
                <Card.Body>
                    <Card.Title className="text-center"> Distribuição dos meios de pagamento </Card.Title>
                    <PieChart
                    series={[{ data: pieData }]}
                    width={700}
                    height={400}
                />
                </Card.Body>
            </Card>
            <Card className="shadow mb-4">
                <Card.Body>
                    <Card.Title className="text-center">Valores totais de cada meio de pagamento</Card.Title>
                    <BarChart
                    xAxis={[{ scaleType: 'band', data: barData.xAxis }]}
                    series={[{ data: barData.series }]}
                    width={700}
                    height={400}    
                    />
                </Card.Body>
            </Card>

        </div>
    )
}

export default HistoricoPagamentos