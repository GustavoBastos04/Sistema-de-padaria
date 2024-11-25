import { useState } from "react";
import {Table, Button} from "react-bootstrap"
import ItemPagamento from "../../components/ListItems/ItemPagamento.jsx";
import SearchInput from "../../components/SearchInputs/SearchInput.jsx";
import pagamentosFakeList from '../../static/pagamentosFakeList.js'
import { PieChart } from '@mui/x-charts/PieChart'

function HistoricoPagamentos() {

    const [currentPage, setCurrentPage] = useState(1)
    const [searchItem, setSearchItem] = useState("")
    const itensPerPage = 10

    const indexOfLastItem = currentPage * itensPerPage
    const indexOfFirstItem = indexOfLastItem - itensPerPage
    
    const filteredItems = pagamentosFakeList.filter((item) => item.forma.toLowerCase().includes(searchItem))
    const currentItems = filteredItems.slice(indexOfFirstItem, indexOfLastItem)

    const totalPages = Math.ceil(filteredItems.length/itensPerPage)

    const handlePageChange = (pageNumber) => {
        setCurrentPage(pageNumber)
    }

    const handleSearch = (term) => {
        setSearchItem(term.toLowerCase())
        setCurrentPage(1)
    }

    return (
        <div className="d-flex justify-content-center align-items-center">
            <PieChart
            series={[
                {
                data: [
                    { id: 0, value: 5, label: 'Pix' },
                    { id: 1, value: 5, label: 'Cartão de crédito' },
                    { id: 2, value: 3, label: 'Dinheiro' },
                    { id: 3, value: 3, label: 'V.A (Vale Alimentação)' },
                    { id: 4, value: 4, label: 'Cartão de débito' },
                ],
                },
            ]}
            width={800}
            height={400}
            />
        </div>
    )
}

export default HistoricoPagamentos