# %% [markdown]
# # Análisis estadístico

# %% [markdown]
# ## Obtención de base de datos

# %%
import mysql.connector as connection
import pandas as pd
import matplotlib.pyplot as plt
from datetime import datetime

# %%


def queryDF(q) -> pd.DataFrame:
    try:
        mydb = connection.connect(
            host="localhost", database='practica',
            user="root", passwd="root", use_pure=True)
        result_dataFrame = pd.read_sql(q, mydb)
    except Exception as e:
        print('Excepcion', str(e))
        result_dataFrame = None
    finally:
        mydb.close()
    return result_dataFrame


# %%
empleados = queryDF('select * from em_empleados')
proyectos = queryDF('select * from pr_proyectos')
asignaciones = queryDF('select * from pr_empleados_proyecto')

# %%
empleados.head()

# %% [markdown]
# ## Estadísticas

# %% [markdown]
# #### Empleados
# - Top 5 empleados que más años llevan en la compañía
# - Top 5 empleados más recientes
# - Distribución del número de años de los empleados en la empresa
# - Evolución temporal de altas por años
# - Evolución temporal de bajas por años (se puede combinar con
# la anterior si se desea)
# - ¿Cuáles han sido los dos años de mayor crecimiento/decrecimiento
# de empleados?
# - Distribución de empleados solteros vs casados
# - Distribución de la edad de los empleados
# - Edad media y desviación típica de los empleados
#
# #### Proyectos
# - Número de proyectos activos, finalizados y total
# - Distribución de la duración de los proyectos (histograma)
# - Distribución de proyectos por lugar
#
# #### Proyectos y Empleados
# - Distribución del número de proyectos a los que están asignados
# los empleados en activo.
# - Ejemplo:
# 	- Personas asignadas a 1 proyecto: 54,
# 	- Personas asignadas a 2 proyectos: 12,
# 	- Personas asignadas a 3 proyectos: 2
# - Top 5 proyectos con más personas asignadas
# - Lista de proyectos sin personas asignadas (detección de anomalía)
#

# %% [markdown]
# ### Empleados

# %% [markdown]
# #### Top 5 empleados que más años llevan en la compañía

# %%
# No dados de baja
disponibles = empleados.loc[empleados['F_BAJA'].isna()].copy()
# Ordenar por antiguedad
ordenados = disponibles.sort_values(['F_ALTA'])[[
    'TX_NIF', 'TX_NOMBRE', 'TX_APELLIDO1', 'TX_APELLIDO2',
    'TX_EMAIL', 'F_ALTA']]
# Limitar a los 5
top5MasAnyos = ordenados.head(5)
top5MasAnyos

# %% [markdown]
# #### Top 5 empleados más recientes

# %%
# No dados de baja
disponibles = empleados.loc[empleados['F_BAJA'].isna()].copy()
# Ordenar por antiguedad
ordenados = disponibles.sort_values(['F_ALTA'], ascending=False)[[
    'TX_NIF', 'TX_NOMBRE', 'TX_APELLIDO1',
    'TX_APELLIDO2', 'TX_EMAIL', 'F_ALTA']]
# Limitar a los 5
top5MasRecientes = ordenados.head(5)
top5MasRecientes

# %% [markdown]
# #### Distribución del número de años de los empleados en la empresa

# %%
# No dados de baja
disponibles = empleados.loc[empleados['F_BAJA'].isna()].copy()
# Numero de años
anyosAlta = disponibles['F_ALTA'].astype(
    'str').str.split('-').str[0].astype('int')
nAnyos = 2023 - anyosAlta

nAnyos.plot.hist(bins=nAnyos.max() - nAnyos.min() + 1)
plt.show()

# %% [markdown]
# #### Evolución temporal de altas por años y Evolución temporal
# de bajas por años

# %%
# Dados de baja
deBaja = empleados.loc[empleados['F_BAJA'].notna()].copy()
anyosBaja = deBaja['F_BAJA'].astype('str').str.split('-').str[0].astype('int')

fig, axes = plt.subplots(nrows=2, ncols=1)
minim = min(anyosAlta.min(), anyosBaja.min())
maxim = max(anyosAlta.max(), anyosBaja.max())
anyosAlta.plot.hist(ax=axes[0], bins=maxim - minim + 1, title='Altas')
anyosBaja.plot.hist(ax=axes[1], bins=maxim - minim + 1, title='Bajas')
plt.show()

# %% [markdown]
#
# #### ¿Cuáles han sido los dos años de mayor crecimiento/decrecimiento
# de empleados?

# %%
anyosCrecimiento = anyosAlta.value_counts().sort_values(
    ascending=False).head(2).reset_index()
anyosDecrecimiento = anyosBaja.value_counts().sort_values(
    ascending=False).head(2).reset_index()

print(
    'Mayor crecimiento: ',
    ', '.join([
        f'{y} con {n} altas'
        for y, n in zip(
            anyosCrecimiento['F_ALTA'],
            anyosCrecimiento['count'])]))

print(
    'Mayor decrecimiento: ',
    ', '.join([
        f'{y} con {n} bajas'
        for y, n in zip(
            anyosDecrecimiento['F_BAJA'],
            anyosDecrecimiento['count'])]))


# %% [markdown]
#
# #### Distribución de empleados solteros vs casados

# %%
ecivil = empleados['CX_EDOCIVIL'].value_counts()
ecivil = ecivil
ecivil.plot.pie(
    label='Frecuencia entre todos',
    labels=['Solteros', 'Casados'],
    autopct=lambda x: f'{round(x * len(empleados) / 100)} ({round(x, 2)}%)')
plt.show()

# %%
ecivil = disponibles['CX_EDOCIVIL'].value_counts()
ecivil = ecivil
ecivil.plot.pie(
    label='Frecuencia entre los no dados de baja',
    labels=['Solteros', 'Casados'],
    autopct=lambda x: f'{round(x * len(disponibles) / 100)} ({round(x, 2)}%)')
plt.show()

# %% [markdown]
#
# #### Distribución de la edad de los empleados

# %%
# No dados de baja
disponibles = empleados.loc[empleados['F_BAJA'].isna()].copy()
# Edad de años
year = datetime.now().year
edadEmpleados = year - \
    disponibles['F_NACIMIENTO'].astype(
        'str').str.split('-').str[0].astype('int')

edadEmpleados.plot.hist(bins=edadEmpleados.max() - edadEmpleados.min() + 1)

# %% [markdown]
#
# #### Edad media y desviación típica de los empleados

# %%
media, std = edadEmpleados.mean(), edadEmpleados.std()

print('La edad media es', round(media, 1),
      'años y la desviación típica', round(std, 2))
print('Por lo que el ~68% de las edades están entre',
      round(media - std, 1), 'y', round(media + std, 1))

# %% [markdown]
# ### Proyectos

# %% [markdown]
#
# #### Número de proyectos activos, finalizados y total

# %%
now = datetime.today().isoformat()[:10]

activos = proyectos.loc[proyectos['F_BAJA'].isna()]
activos = activos.loc[activos['F_FIN'].astype('str') <= now]
nactivos = len(activos)

finalizados = proyectos.loc[proyectos['F_BAJA'].isna()]
finalizados = finalizados.loc[finalizados['F_FIN'].astype('str') > now]
nfinalizados = len(finalizados)

nbaja = len(proyectos.loc[proyectos['F_BAJA'].notna()])

totalSinBajas = nfinalizados + nactivos

totalConBajas = totalSinBajas + nbaja


# %%

_, (left, right) = plt.subplots(1, 2, layout='constrained')

left.set(title='Proyectos sin bajas', aspect=1)
right.set(title='Proyectos incluyendo bajas', aspect=1)


x = (nactivos, nfinalizados)
left.pie(
    x, labels=('Activos', 'Finalizados'),
    autopct=lambda n: f'{round(n * totalSinBajas / 100)} ({round(n, 2)}%)')

x = (nactivos, nfinalizados, nbaja)
right.pie(
    x, labels=('Activos', 'Finalizados', 'Baja'),
    autopct=lambda n: f'{round(n * totalConBajas / 100)} ({round(n, 2)}%)')

plt.show()

# %%
print((
    'Proyectos:\n- {} Activos\n- {} Finalizados\n- '
    '{} Total\n- {} Total (con bajas)').format(
        nactivos, nfinalizados, totalSinBajas, totalConBajas))

# %% [markdown]
#
# #### Distribución de la duración de los proyectos (histograma)

# %%
proyectos['F_INICIO'] = pd.to_datetime(
    proyectos['F_INICIO'], format='%y-%m-%d')
proyectos['F_FIN'] = pd.to_datetime(proyectos['F_FIN'], format='%y-%m-%d')

# %%


def form(delta, _):
    y = int(delta // 365)
    return f'{y}'


duraciones = (proyectos['F_FIN'] - proyectos['F_INICIO']).dt.days
p = duraciones.plot.hist()
p.xaxis.set_major_formatter(form)
p.set(title='Duración de proyectos (en años)')
plt.show()

# %% [markdown]
#
# #### Distribución de proyectos por lugar

# %%
lugares = proyectos['TX_LUGAR']
frecLugares = lugares.value_counts().reset_index()
plt.bar(frecLugares['TX_LUGAR'], frecLugares['count'])
plt.show()

# %% [markdown]
# ### Proyectos y empleados

# %% [markdown]
# #### Distribución del número de proyectos a los que están asignados
# los empleados en activo.

# %%
asignados = asignaciones['ID_EMPLEADO']
asignados = asignados.value_counts().reset_index()
asignados = asignados.groupby('count').count().reset_index()
print(
    ',\n'.join(
        f'- Personas asignadas a {c} proyecto{"s" if c != 1 else ""}: {n}'
        for c, n in zip(asignados['count'], asignados['ID_EMPLEADO'])
    ))

# %% [markdown]
#
# #### Top 5 proyectos con más personas asignadas

# %%
top5 = asignaciones['ID_PROYECTO']
top5 = (top5.value_counts(['ID_EMPLEADO']) *
        len(top5)).astype('int').reset_index()[:5]
top5proyectos = top5.join(
    proyectos[['ID_PROYECTO', 'TX_DESCRIPCION']],
    on='ID_PROYECTO',
    rsuffix='_new')[['ID_PROYECTO', 'TX_DESCRIPCION', 'proportion']]

top5proyectos

# %% [markdown]
#
# #### Lista de proyectos sin personas asignadas (detección de anomalía)

# %%
proyectosAsignados = asignaciones['ID_PROYECTO'].unique()
noasignados = ~proyectos['ID_PROYECTO'].isin(proyectosAsignados)

pnoasig = proyectos.loc[noasignados]
pnoasig.loc[pnoasig['F_BAJA'].isna()][[
    'ID_PROYECTO', 'TX_DESCRIPCION', 'TX_OBSERVACIONES',
    'TX_LUGAR', 'F_INICIO', 'F_FIN']]
